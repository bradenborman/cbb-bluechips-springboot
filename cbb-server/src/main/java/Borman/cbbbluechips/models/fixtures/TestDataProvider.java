package Borman.cbbbluechips.models.fixtures;

import Borman.cbbbluechips.models.GameData;
import Borman.cbbbluechips.models.UserGameData;

public class TestDataProvider {

    public static UserGameData userGameDataFixture() {
        UserGameData x = new UserGameData();
        x.setNetWorth(50000);
        x.setCash(15000);
        x.setFullName("TEST USER");
        x.setLeaderboardPosition(1000);
        x.setUserTransactionCount(58);
        return x;
    }

    public static GameData gameDataFixture() {
        GameData x = new GameData();
        x.setTotalMoneyInPlay(600000);
        x.setCurrentRound("32");
        x.setTotalTransactionsCount(3521);
        return x;
    }

}