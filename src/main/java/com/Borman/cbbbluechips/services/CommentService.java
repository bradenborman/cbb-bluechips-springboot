package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.builders.CommentBuilder;
import com.Borman.cbbbluechips.daos.CommentsDao;
import com.Borman.cbbbluechips.models.Comment;
import com.Borman.cbbbluechips.utilities.NumberGenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CommentService {


    @Autowired
    CommentsDao commentsDao;

    public List<Comment> getComments() {
        List<Comment> baseComments = commentsDao.getComments();
        baseComments.forEach(comment -> comment.setSubComments(getSubComments(comment.getCommentId())));
        return baseComments;
    }

    private List<Comment> getSubComments(String parentId) {
        return commentsDao.getSubComments(parentId);
    }

}
