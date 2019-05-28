package com.Borman.cbbbluechips.services;

import com.Borman.cbbbluechips.daos.OwnsDao;
import com.Borman.cbbbluechips.daos.TeamDao;
import com.Borman.cbbbluechips.models.Owns;
import com.Borman.cbbbluechips.models.TradeRequest;
import com.Borman.cbbbluechips.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnsService {

    @Autowired
    OwnsDao ownsDao;

    @Autowired
    TeamDao teamDao;

    public List<Owns> getTeamsUserOwns(String user) {
        return ownsDao.getTeamsUserOwns(user);
    }

    //Gets current amount before trade and then also prevents negative numbers to be passed in
    public boolean validateOwnership(TradeRequest tradeRequest) {
       return (tradeRequest.getVolume() <= ownsDao.getAmountOfSharesOwned(tradeRequest)) && tradeRequest.getVolume() > 0;
    }

    public double getFundsAvailable(TradeRequest tradeRequest) {
        return ownsDao.getFundsAvailable(tradeRequest.getUserId());
    }


    int calculateAvailableCanSell(String userId, String teamId) {
        return ownsDao.getAmountOfSharesOwned(userId, teamId);
    }

    int calculateAvailableCanPurchase(double cash, String teamId) {
        double currentMarketPrice = teamDao.getCurrentMarketPrice(teamId);
        return (int) Math.floor(cash / currentMarketPrice);
    }

    List<Owns> getTopShareHoldersForTeam(String teamId) {
        return ownsDao.getUsersOwnsForTeam(teamId);
    }

    public double getPortfolioValue(String user_id) {
        return ownsDao.getPortfolioValue(user_id);
    }


    public double getTotalMoneyInPlay() {
        return ownsDao.getTotalMoneyInPlay();
    }
}
