package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.mappers.rowMappers.CommentRowMapper;
import com.Borman.cbbbluechips.mappers.rowMappers.SubCommentRowMapper;
import com.Borman.cbbbluechips.models.Comment;
import com.Borman.cbbbluechips.utilities.CommentTimeStampUtility;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CommentsDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Comment> getComments() {
        return namedParameterJdbcTemplate.query("SELECT * FROM comments;", new CommentRowMapper());
    }

    public List<Comment> getSubComments(String parentId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("parentId", parentId);
        return namedParameterJdbcTemplate.query("SELECT * FROM sub_comments WHERE Parent_ID = :parentId;", params, new SubCommentRowMapper());
    }

    public void createReplyToParentComment(String userId, String reply, String parentId, String fullName) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("reply", reply)
                .addValue("parentId", parentId)
                .addValue("author", fullName)
                .addValue("date", CommentTimeStampUtility.getDate())
                .addValue("time", CommentTimeStampUtility.getTime());;

        String sql = "INSERT INTO sub_comments (Parent_ID, Author, Sub_Comment, Author_ID, Sub_Date, Sub_Time) VALUES (:parentId, :author, :reply, :userId, :date, :time);";
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void createParentComment(String userId, String comment, String fullName) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("comment", comment)
                .addValue("author", fullName)
                .addValue("date", CommentTimeStampUtility.getDate())
                .addValue("time", CommentTimeStampUtility.getTime());

        String sql = "INSERT INTO comments (Author, Comment, Author_ID, Date, Time) VALUES (:author, :comment, :userId, :date, :time);";
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteParentCommentById(String commentId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("commentId", commentId);
        String sql = "DELETE FROM comments WHERE Comment_Id = :commentId;";
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteSubCommentById(String commentId) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("commentId", commentId);
        String sql = "DELETE FROM sub_comments WHERE Sub_Comment_ID = :commentId;";
        namedParameterJdbcTemplate.update(sql, params);
    }
}
