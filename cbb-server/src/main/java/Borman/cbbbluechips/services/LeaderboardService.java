package Borman.cbbbluechips.services;

import Borman.cbbbluechips.models.LeaderBoardUser;
import Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LeaderboardService {

    OwnsService ownsService;
    UserGroupService userGroupService;
    UserService userService;
    int LEADERS_TO_DISPLAY_AMT;

    public LeaderboardService(OwnsService ownsService, UserGroupService userGroupService, UserService userService,
                              @Qualifier("leadersToDisplay") int LEADERS_TO_DISPLAY_AMT) {
        this.ownsService = ownsService;
        this.userGroupService = userGroupService;
        this.userService = userService;
        this.LEADERS_TO_DISPLAY_AMT = LEADERS_TO_DISPLAY_AMT;
    }

    public List<LeaderBoardUser> getLeaders() {
        return ownsService.retrieveLeaderboard();
    }


    public int getUsersLeaderPosition(User user) {
        return ownsService.retrieveLeaderboard()
                .stream()
                .filter(entry -> entry.getEmailAddress().equals(user.getEmail()))
                .findFirst()
                .orElse(new LeaderBoardUser("", -1, 0, "", false)).getRanking();
    }

    //TODO takes forever -- might look into making this straight up sql
    public int getUsersLeaderPosition(String userId) {
        String userEmail = userService.retrieveUserEmailById(userId);
        return ownsService.retrieveLeaderboard()
                .stream()
                .filter(entry -> entry.getEmailAddress().equals(userEmail))
                .findFirst()
                .orElse(new LeaderBoardUser("", -1, 0, "", false)).getRanking();
    }

    public List<LeaderBoardUser> fetchLeaderBoardDetailsForGroup(String groupId) {
        List<User> playersId = userGroupService.getUsersInGroup(groupId);
        playersId.forEach(player -> player.setCash(ownsService.getPortfolioValue(player.getID()) + ownsService.getFundsAvailable(player.getID())));
        playersId.sort(Comparator.comparing(User::getCash).reversed());
        List<LeaderBoardUser> leaders = new ArrayList<>();
        int i = 1, playersIdSize = playersId.size();
        while (i <= playersIdSize) {
            User user = playersId.get(i - 1);
            leaders.add(new LeaderBoardUser(user.getFirstName() + " " + user.getLastName(), i, user.getCash(), user.getEmail(), user.isHasPayedEntryFee()));
            i++;
        }
        return leaders;
    }
}