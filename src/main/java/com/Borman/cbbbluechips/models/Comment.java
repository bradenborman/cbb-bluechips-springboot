package com.Borman.cbbbluechips.models;

import java.time.LocalDateTime;
import java.util.List;

public class Comment {

    private String commentId;
    private String author;
    private String commentValue;
    private String authorId;
    private List<Comment> subComments;
    private LocalDateTime timeOfComment;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCommentValue() {
        return commentValue;
    }

    public void setCommentValue(String commentValue) {
        this.commentValue = commentValue;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public List<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }

    public LocalDateTime getTimeOfComment() {
        return timeOfComment;
    }

    public void setTimeOfComment(LocalDateTime timeOfComment) {
        this.timeOfComment = timeOfComment;
    }
}
