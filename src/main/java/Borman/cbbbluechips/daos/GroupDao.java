package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.daos.sql.GroupSQL;
import Borman.cbbbluechips.mappers.UserGroupsRowMapper;
import Borman.cbbbluechips.models.usergroups.AddUserToGroupRequest;
import Borman.cbbbluechips.models.usergroups.GroupCreationRequest;
import Borman.cbbbluechips.models.usergroups.RemoveUserFromGroupRequest;
import Borman.cbbbluechips.models.usergroups.UserGroup;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
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
        params.addValue("groupId", request.getGroupId());
        params.addValue("userId", request.getUserId());
        params.addValue("assocId", request.getGroupAssocId());
        namedParameterJdbcTemplate.update(GroupSQL.removeUserFromGroup, params);
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
        try {
            Integer doesOwn = namedParameterJdbcTemplate.queryForObject(GroupSQL.doesUserBelongToGroupAlready, params, Integer.class);
            return doesOwn != null && doesOwn > 0;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }


    public boolean isPasswordCorrect(AddUserToGroupRequest request) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", request.getGroupId());
        params.addValue("password", request.getGroupPassword());
        try {
            Integer validGroupId = namedParameterJdbcTemplate.queryForObject(GroupSQL.isPasswordCorrect, params, Integer.class);
            return validGroupId != null && validGroupId > 0;
        }catch (EmptyResultDataAccessException e) {
            return false;
        }
    }


    public List<UserGroup> getGroupsUserBelongsTo(String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        return namedParameterJdbcTemplate.query(GroupSQL.getGroupsUserBelongsTo, params, new UserGroupsRowMapper());
    }


    public List<UserGroup> getOpenGroups(String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        return namedParameterJdbcTemplate.query(GroupSQL.getGroupsUserDoesNotBelongsTo, params, new UserGroupsRowMapper());
    }


    public Integer fetchMemberPopulationForGroup(String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", groupId);
        return namedParameterJdbcTemplate.queryForObject(GroupSQL.fetchMemberPopulationForGroup, params, Integer.class);
    }

}