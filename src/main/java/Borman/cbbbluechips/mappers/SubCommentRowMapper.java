package Borman.cbbbluechips.mappers;

import Borman.cbbbluechips.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SubCommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rownumber) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getString("Sub_Comment_ID"));
        comment.setAuthor(rs.getString("Author"));
        comment.setAuthorId(rs.getString("Author_ID"));
        comment.setCommentValue(rs.getString("Sub_Comment"));

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
            LocalDateTime localDateTime = LocalDateTime.parse(rs.getString("Sub_Date") + " " + rs.getString("Sub_Time"), formatter);
            comment.setTimeOfComment(localDateTime);
        } catch (Exception e) {
            comment.setTimeOfComment(LocalDateTime.now());
        }


        return comment;
    }

}