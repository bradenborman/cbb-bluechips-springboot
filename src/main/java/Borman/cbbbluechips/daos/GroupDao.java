package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.daos.sql.GroupSQL;
import Borman.cbbbluechips.models.GroupCreationRequest;
import Borman.cbbbluechips.models.RemoveUserFromGroupRequest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class GroupDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public GroupDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String createNewGroup(GroupCreationRequest request) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", request.getUserIdCreatingGroup());
        params.addValue("groupName", request.getGroupName());
        params.addValue("description", request.getGroupDescription());
        namedParameterJdbcTemplate.update(GroupSQL.createNewGroup, params, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).toString();
    }

    public void removeUserFromGroup(RemoveUserFromGroupRequest request) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", request.getGroupID());
        params.addValue("userId", request.getUserIdCreatingGroup());
        params.addValue("groupAssocId", request.getGroupAssocID());
        namedParameterJdbcTemplate.update(GroupSQL.createNewGroup, params);
    }

    public void addUserIdToGroup(String userId, String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        params.addValue("groupId", groupId);
        params.addValue("timeJoined", LocalDateTime.now());
        namedParameterJdbcTemplate.update(GroupSQL.addUserToGroup, params);
    }

    public boolean doesUserBelongToGroup(String userId, String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        params.addValue("groupId", groupId);
        Integer doesOwn = namedParameterJdbcTemplate.queryForObject(GroupSQL.doesUserBelongToGroupAlready, params, Integer.class);
        return doesOwn != null && doesOwn > 0;
    }



}