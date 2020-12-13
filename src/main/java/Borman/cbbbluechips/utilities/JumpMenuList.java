package Borman.cbbbluechips.utilities;

import Borman.cbbbluechips.builders.JumpMenuItemBuilder;
import Borman.cbbbluechips.models.JumpMenuItem;
import Borman.cbbbluechips.models.Team;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JumpMenuList {

    private static Predicate<Team> isPlayingToday = team -> team.getNextTeamPlaying() != null;

    public static List<JumpMenuItem> buildQuickJumpList(List<Team> teamsToReturn) {
        return teamsToReturn.stream()
                .filter(isPlayingToday)
                .map(JumpMenuList::buildItem).collect(Collectors.toList());

    }

    private static JumpMenuItem buildItem(Team team) {
        return JumpMenuItemBuilder.aJumpMenuItem()
                .withDisplayString(team.getTeamName())
                .withUrl("team:".concat(team.getTeamName()))
                .withLocked(team.isLocked())
                .build();
    }

}