package com.Borman.cbbbluechips.builders;

import com.Borman.cbbbluechips.models.Comment;

import java.time.LocalDateTime;
import java.util.List;

public final class CommentBuilder {
    private String commentId;
    private String author;
    private String commentValue;
    private String authorId;
    private List<Comment> subComments;
    private LocalDateTime timeOfComment;

    private CommentBuilder() {
    }

    public static CommentBuilder aComment() {
        return new CommentBuilder();
    }

    public CommentBuilder withCommentId(String commentId) {
        this.commentId = commentId;
        return this;
    }

    public CommentBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public CommentBuilder withCommentValue(String commentValue) {
        this.commentValue = commentValue;
        return this;
    }

    public CommentBuilder withAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public CommentBuilder withSubComments(List<Comment> subComments) {
        this.subComments = subComments;
        return this;
    }

    public CommentBuilder withTimeOfComment(LocalDateTime timeOfComment) {
        this.timeOfComment = timeOfComment;
        return this;
    }

    public Comment build() {
        Comment comment = new Comment();
        comment.setCommentId(commentId);
        comment.setAuthor(author);
        comment.setCommentValue(commentValue);
        comment.setAuthorId(authorId);
        comment.setSubComments(subComments);
        comment.setTimeOfComment(timeOfComment);
        return comment;
    }
}
