package com.Borman.cbbbluechips.daos.sql;

public class OwnsSQL {

    public static final String getTeamsUserOwnsSQL = "SELECT Owns_ID, User_ID, teams.Team_ID, Amount_Owned, Name, Seed, Point_Spread, Is_Out  FROM owns " +
            "Right JOIN teams ON owns.Team_ID = teams.Team_ID " +
            "WHERE User_ID = :userId;";

    public static final String insertIntoOwns = "INSERT INTO owns (Owns_ID, Team_ID, User_ID, Amount_Owned) VALUES (null, :teamId, :userId, :amountOwned)";

    public static final String getCurrentAmountOwned = "SELECT Amount_Owned FROM owns where Team_ID = :teamId AND User_ID = :userId";

    public static final String getCurrentMarketPrice = "SELECT Current_Market_Price FROM teams where Team_ID = :teamId";

}
