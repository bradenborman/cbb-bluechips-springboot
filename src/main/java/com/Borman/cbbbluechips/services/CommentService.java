package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.CommentsDao;
import com.Borman.cbbbluechips.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    CommentsDao commentsDao;

    @Autowired
    UserService userService;

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
        commentsDao.createReplyToParentComment(userId, reply, parentId, fullName);
    }



}
