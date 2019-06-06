package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rownumber) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getString("Comment_ID"));
        comment.setAuthor(rs.getString("Author"));
        comment.setCommentValue(rs.getString("Comment"));
        comment.setAuthorId(rs.getString("Author_ID"));

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime localDateTime = LocalDateTime.parse(rs.getString("Date") + " " + rs.getString("Time"), formatter);
            comment.setTimeOfComment(localDateTime);
        } catch (Exception e) {
            comment.setTimeOfComment(LocalDateTime.now());
        }
        return comment;
    }

}