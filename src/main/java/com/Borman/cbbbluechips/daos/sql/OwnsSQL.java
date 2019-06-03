package com.Borman.cbbbluechips.daos.sql;

public class OwnsSQL {

    public static final String getTeamsUserOwnsSQL = "SELECT Owns_ID, User_ID, teams.Team_ID, Amount_Owned, Name, Seed, Point_Spread, Is_Out, Current_Market_Price FROM owns " +
            "Right JOIN teams ON owns.Team_ID = teams.Team_ID " +
            "WHERE User_ID = :userId AND Amount_Owned > 0;";

    public static final String getUserOwnsTeamsSQL_Limit3 = "SELECT Owns_ID, Team_ID, user.User_ID, Amount_Owned, First_Name, Last_Name, Email FROM owns " +
            "Right JOIN user ON user.User_ID = owns.User_ID " +
            "Where Team_ID = :teamId ORDER BY Amount_Owned desc limit 3";


    public static final String getUsersWhoOwnedTeamWithTextAlertOn = "SELECT Owns_ID, Team_ID, user.User_ID, Amount_Owned, First_Name, Last_Name, Email, Phone_Number, Send_Alerts " +
            "FROM owns " +
            "Right JOIN user ON user.User_ID = owns.User_ID " +
            "Where Team_ID = :teamId AND Send_Alerts != 0 AND Amount_Owned > 0";


    public static final String insertIntoOwns = "INSERT INTO owns (Owns_ID, Team_ID, User_ID, Amount_Owned) VALUES (null, :teamId, :userId, :amountOwned)";

    public static final String updateAmountOwned = "UPDATE owns SET Amount_Owned = :amountOwned WHERE (User_ID = :userId AND Team_ID = :teamId)";

    public static final String getCurrentAmountOwned = "SELECT Amount_Owned FROM owns where Team_ID = :teamId AND User_ID = :userId";

    public static final String getCurrentMarketPrice = "SELECT Current_Market_Price FROM teams where Team_ID = :teamId";

    public static final String getFundsAvailable = "SELECT Cash FROM user where User_ID = :userId";

    public static final String countEmailAddress = "SELECT count(Email) FROM user WHERE Email = :email;";

    public static final String getPortfolioValueByID = "SELECT SUM(Amount_Owned * Current_Market_Price) " +
            "FROM owns Right JOIN teams ON owns.Team_ID = teams.Team_ID " +
            "WHERE User_ID = :userId AND Amount_Owned > 0";

    public static final String getTotalMoneyInPlay = "SELECT SUM(Amount_Owned * Current_Market_Price) + (Select Sum(Cash) From User) " +
            "FROM owns Right JOIN teams ON owns.Team_ID = teams.Team_ID;";

}
