package com.Borman.cbbbluechips.mappers.rowMappers;

import com.Borman.cbbbluechips.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

public class SubCommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rownumber) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getString("Sub_Comment_ID"));
        comment.setAuthor(rs.getString("Author"));
        comment.setCommentValue(rs.getString("Sub_Comment"));

        //TODO
        try {
            Date date = rs.getDate("Sub_Date");
            Time time = rs.getTime("Sub_TIme");
            comment.setTimeOfComment(LocalDateTime.now());
        } catch (Exception e) {
            System.out.println("Failed to make date");
        }


        return comment;
    }

}