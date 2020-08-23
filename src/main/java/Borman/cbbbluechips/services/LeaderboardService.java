package Borman.cbbbluechips.services;

import Borman.cbbbluechips.models.LeaderboardUser;
import Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaderboardService {

    private OwnsService ownsService;
    private int LEADERS_TO_DISPLAY_AMT;

    public LeaderboardService(OwnsService ownsService, @Qualifier("leadersToDisplay") int LEADERS_TO_DISPLAY_AMT) {
        this.ownsService = ownsService;
        this.LEADERS_TO_DISPLAY_AMT = LEADERS_TO_DISPLAY_AMT;
    }

    public List<LeaderboardUser> getLeaders() {
        List<LeaderboardUser> leaders = ownsService.getLeaders()
                .stream()
                .limit(LEADERS_TO_DISPLAY_AMT)
                .collect(Collectors.toList());

        while (leaders.size() < LEADERS_TO_DISPLAY_AMT) {
            leaders.add(new LeaderboardUser("", leaders.size() + 1, 0.00, "Empty user."));
        }

        return leaders;

        //.skip(15) to get everyone else mght need to test and make sure its 15 not 14
    }


    public int getUsersLeaderPosition(User user) {
        return ownsService.getLeaders().stream()
                .filter(entry -> entry.getEmailAddress().equals(user.getEmail()))
                .findFirst()
                .orElse(new LeaderboardUser("", -1, 0, "")).getRanking();
    }

}