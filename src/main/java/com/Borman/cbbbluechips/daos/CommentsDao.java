package com.Borman.cbbbluechips.daos;

import com.Borman.cbbbluechips.mappers.rowMappers.CommentRowMapper;
import com.Borman.cbbbluechips.mappers.rowMappers.SubCommentRowMapper;
import com.Borman.cbbbluechips.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Comment> getComments() {
        return namedParameterJdbcTemplate.query("SELECT * FROM comments;", new CommentRowMapper());
    }


    public List<Comment> getSubComments(String parentId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("parentId", parentId);
        return namedParameterJdbcTemplate.query("SELECT * FROM sub_comments WHERE Parent_ID = :parentId;", params, new SubCommentRowMapper());
    }
}
