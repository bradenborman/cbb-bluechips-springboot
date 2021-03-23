package Borman.cbbbluechips.services;

import Borman.cbbbluechips.models.LeaderBoardUser;
import Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaderboardService {

    OwnsService ownsService;
    UserGroupService userGroupService;
    int LEADERS_TO_DISPLAY_AMT;

    public LeaderboardService(OwnsService ownsService, UserGroupService userGroupService,  @Qualifier("leadersToDisplay") int LEADERS_TO_DISPLAY_AMT) {
        this.ownsService = ownsService;
        this.userGroupService = userGroupService;
        this.LEADERS_TO_DISPLAY_AMT = LEADERS_TO_DISPLAY_AMT;
    }

    public List<LeaderBoardUser> getLeaders() {
        List<LeaderBoardUser> allBoard = ownsService.getLeaders();
        List<LeaderBoardUser> leaders = allBoard
                .stream()
                .limit(LEADERS_TO_DISPLAY_AMT)
                .collect(Collectors.toList());

        while (leaders.size() < LEADERS_TO_DISPLAY_AMT) {
            leaders.add(new LeaderBoardUser("", leaders.size() + 1, 0.00, "Empty user.", false));
        }

        //ADD last 3 to board
        allBoard.stream()
                .skip(allBoard.size() - 3)
                .forEach(leaders::add);


        return leaders;

        //.skip(15) to get everyone else mght need to test and make sure its 15 not 14
    }


    public int getUsersLeaderPosition(User user) {
        return ownsService.getLeaders().stream()
                .filter(entry -> entry.getEmailAddress().equals(user.getEmail()))
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