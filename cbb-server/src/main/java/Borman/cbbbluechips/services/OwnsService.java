package Borman.cbbbluechips.services;

import Borman.cbbbluechips.daos.OwnsDao;
import Borman.cbbbluechips.daos.TeamDao;
import Borman.cbbbluechips.daos.UserDao;
import Borman.cbbbluechips.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class OwnsService {

    private OwnsDao ownsDao;
    private TeamDao teamDao;
    private UserDao userDao;

    public OwnsService(OwnsDao ownsDao, TeamDao teamDao, UserDao userDao) {
        this.ownsDao = ownsDao;
        this.teamDao = teamDao;
        this.userDao = userDao;
    }

    @Deprecated
    public List<Owns> getTeamsUserOwns(String user) {
        return ownsDao.getTeamsUserOwns(user);
    }

    //Gets current amount before trade and then also prevents negative numbers to be passed in
    public boolean validateOwnership(TradeRequest tradeRequest) {
        return (tradeRequest.getVolume() <= ownsDao.getAmountOfSharesOwned(tradeRequest)) && tradeRequest.getVolume() > 0;
    }

    public double getFundsAvailable(String userId) {
        return ownsDao.getFundsAvailable(userId);
    }

    public double getFundsAvailable(TradeRequest tradeRequest) {
        return ownsDao.getFundsAvailable(tradeRequest.getUserId());
    }


    int calculateAvailableCanSell(String userId, String teamId) {
        return ownsDao.getAmountOfSharesOwned(userId, teamId);
    }

    @Deprecated
    int calculateAvailableCanPurchase(double cash, String teamId) {
        double currentMarketPrice = teamDao.getCurrentMarketPrice(teamId);
        return (int) Math.floor(cash / currentMarketPrice);
    }

    List<Owns> getTopShareHoldersForTeam(String teamId) {
        return ownsDao.getTopShareHoldersForTeam(teamId);
    }

    public double getPortfolioValue(String user_id) {
        return ownsDao.getPortfolioValue(user_id);
    }


    public double getTotalMoneyInPlay() {
        return ownsDao.getTotalMoneyInPlay();
    }


    public void setTeamsUserOwns(List<Team> teamsToReturn, String userIdLoggedIn) {
        List<Owns> userOwns = ownsDao.getTeamsUserOwns(userIdLoggedIn);

        for (Team team : teamsToReturn) {
            if (userOwns.stream().anyMatch(owns -> owns.getTeamName().equals(team.getTeamName())))
                team.setDoesUserOwn(true);
        }

    }

    public List<SMS_Alert> getUsersWhoOwnedTeamWithTextAlertOn(String teamId) {
        return ownsDao.getUsersWhoOwnedTeamWithTextAlertOn(teamId);
    }



    String getLeadersValue() {
        List<User> playersId = getUsersWithSetNetworth();
        Optional<User> leader = playersId.stream().max(Comparator.comparing(User::getCash));
        return leader.map(user -> String.valueOf(user.getCash())).orElse("0");
    }

    List<LeaderBoardUser> getLeaders() {
        List<User> playersId = getUsersWithSetNetworth();
        playersId.sort(Comparator.comparing(User::getCash).reversed());
        List<LeaderBoardUser> leaders = new ArrayList<>();
        int i = 1, playersIdSize = playersId.size();
        while (i <= playersIdSize) {
            User user = playersId.get(i - 1);
            leaders.add(new LeaderBoardUser(user.getFirstName().charAt(0) + ". " + user.getLastName(), i, user.getCash(), user.getEmail(), user.isHasPayedEntryFee()));
            i++;
        }
        return leaders;
    }

    public List<LeaderBoardUser> getLeadersAnalyticData() {
        List<User> playersId = getUsersWithSetNetworth();
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

    //Sets Networth as CASH even though not all is cash
    private List<User> getUsersWithSetNetworth() {
        List<User> playersId = userDao.getUsers();
        playersId.forEach(player -> player.setCash(ownsDao.getPortfolioValue(player.getID()) + ownsDao.getFundsAvailable(player.getID())));
        return playersId;
    }

    public void deleteUser(String userId) {
        ownsDao.deleteUserOwns(userId);
    }
}