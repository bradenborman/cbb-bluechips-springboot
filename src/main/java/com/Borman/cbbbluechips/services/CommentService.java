package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.CommentsDao;
import com.Borman.cbbbluechips.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class CommentService {


    @Autowired
    CommentsDao commentsDao;

    @Autowired
    UserService userService;

    private Predicate<String> commentHasValue = i -> (i.length() > 0);

    public List<Comment> getComments() {
        List<Comment> baseComments = commentsDao.getComments();
        baseComments.forEach(comment -> comment.setSubComments(getSubComments(comment.getCommentId())));
        return baseComments;
    }

    private List<Comment> getSubComments(String parentId) {
        return commentsDao.getSubComments(parentId);
    }


    public void createReplyToParentComment(String userId, String reply, String parentId) {
        String fullName = userService.getUserFullName(userId);
        if (commentHasValue.test(reply))
            commentsDao.createReplyToParentComment(userId, reply, parentId, fullName);
    }


    public void createParentComment(String userId, String comment) {
        String fullName = userService.getUserFullName(userId);
        if (commentHasValue.test(comment))
            commentsDao.createParentComment(userId, comment, fullName);
    }


}
