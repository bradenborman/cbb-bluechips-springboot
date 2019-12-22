package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.CommentsDao;
import com.Borman.cbbbluechips.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CommentService {


    @Autowired
    CommentsDao commentsDao;

    @Autowired
    UserService userService;

    private Predicate<String> commentHasValue = i -> (i.length() > 0);

    public List<Comment> getComments(String userId, boolean userAdmin) {
        List<Comment> comments =  getComments(userId);

        //give admin ability to delete comments
        if(userAdmin)
            comments.forEach(comment -> {
                comment.getSubComments().forEach(subComment -> {
                    subComment.setUserOwnsComment(true);
                });
                comment.setUserOwnsComment(true);
            });

        //Get newer comments first
        Collections.reverse(comments);

        return comments;
    }


    private List<Comment> getComments(String userId) {
        List<Comment> baseComments = commentsDao.getComments();
        baseComments.forEach(comment -> comment.setSubComments(getSubComments(comment.getCommentId(), userId)));
        isCommentUserCreatedCheck(baseComments, userId);
        return baseComments;
    }

    private List<Comment> getSubComments(String parentId, String userId) {
        List<Comment> subComments = commentsDao.getSubComments(parentId);
        isCommentUserCreatedCheck(subComments, userId);
        return subComments;
    }

    private void isCommentUserCreatedCheck(List<Comment> comments, String userId) {
        comments.forEach(comment -> {
            if (comment.getAuthorId() != null && comment.getAuthorId().equals(userId))
                comment.setUserOwnsComment(true);
        });
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


    public void deleteComment(String commentId, boolean isParentComment) {
        if (isParentComment)
            commentsDao.deleteParentCommentById(commentId);
        else
            commentsDao.deleteSubCommentById(commentId);
    }

}
