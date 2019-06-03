package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.mappers.rowMappers.CommentRowMapper;
import com.Borman.cbbbluechips.mappers.rowMappers.SubCommentRowMapper;
import com.Borman.cbbbluechips.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


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
                .addValue("author", fullName);

        String sql = "INSERT INTO sub_comments (Parent_ID, Author, Sub_Comment, Author_ID) VALUES (:parentId, :author, :reply, :userId);";
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void createParentComment(String userId, String comment, String fullName) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("comment", comment)
                .addValue("author", fullName);

        String sql = "INSERT INTO comments (Author, Comment, Author_ID) VALUES (:author, :comment, :userId);";
        namedParameterJdbcTemplate.update(sql, params);
    }

}
