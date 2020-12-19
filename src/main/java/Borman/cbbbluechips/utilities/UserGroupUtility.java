package Borman.cbbbluechips.utilities;

import Borman.cbbbluechips.models.usergroups.UserGroup;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserGroupUtility {

    public static List<UserGroup> combineJoinedAndOpenGroupLists(List<UserGroup> joined, List<UserGroup> open) {
        return Stream.concat(joined.stream(), open.stream()
        ).sorted(
                Comparator.comparing(UserGroup::isUserJoinedGroup))
                .collect(Collectors.toList()
        );
    }

}