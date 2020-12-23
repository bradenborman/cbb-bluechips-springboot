package Borman.cbbbluechips.daos;

import Borman.cbbbluechips.daos.sql.GroupSQL;
import Borman.cbbbluechips.mappers.GroupRowMapper;
import Borman.cbbbluechips.mappers.SimpleGroupRowMapper;
import Borman.cbbbluechips.mappers.UserGroupsRowMapper;
import Borman.cbbbluechips.mappers.UserRowMapper;
import Borman.cbbbluechips.models.User;
import Borman.cbbbluechips.models.usergroups.*;
import Borman.cbbbluechips.utilities.UserGroupUtility;
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
        params.addValue("password", request.getGroupPassword().trim());
        params.addValue("passwordRequired", UserGroupUtility.isPasswordRequired(request));
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
        return namedParameterJdbcTemplate.query(GroupSQL.getGroupsUserDoesNotBelongsTo, params, new SimpleGroupRowMapper());
    }


    public Integer fetchMemberPopulationForGroup(String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", groupId);
        return namedParameterJdbcTemplate.queryForObject(GroupSQL.fetchMemberPopulationForGroup, params, Integer.class);
    }

    public void deleteUserFromAllGroups(String userId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("userId", userId);
        namedParameterJdbcTemplate.update(GroupSQL.deleteUserFromAllGroups, params);
    }

    public Group getGroupDetailById(String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", groupId);
        return namedParameterJdbcTemplate.query(GroupSQL.getGroupDetailById, params, new GroupRowMapper()).get(0);
    }

    public List<User> getUsersInGroup(String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", groupId);
        return namedParameterJdbcTemplate.query(GroupSQL.getUsersInGroup, params, new UserRowMapper());
    }

    public void deleteGroup(String groupId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("groupId", groupId);
        namedParameterJdbcTemplate.update(GroupSQL.deleteGroup, params);
    }

}