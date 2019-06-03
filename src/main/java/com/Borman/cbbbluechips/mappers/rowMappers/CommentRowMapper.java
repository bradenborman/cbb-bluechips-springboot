package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rownumber) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getString("Comment_ID"));
        comment.setAuthor(rs.getString("Author"));
        comment.setCommentValue(rs.getString("Comment"));

        //TODO
        try {
            Date date = rs.getDate("Date");
            Time time = rs.getTime("Time");
            comment.setTimeOfComment(LocalDateTime.now());
        } catch (Exception e) {
            System.out.println("Failed to make date");
        }


        return comment;
    }

}