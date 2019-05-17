package com.Borman.cbbbluechips.daos.sql;

public class OwnsSQL {

    public static final String getTeamsUserOwnsSQL = "SELECT Owns_ID, User_ID, teams.Team_ID, Amount_Owned, Name, Seed, Point_Spread, Is_Out  FROM owns " +
            "Right JOIN teams ON owns.Team_ID = teams.Team_ID " +
            "WHERE User_ID = :userId;";

    public static final String insertIntoOwns = "INSERT INTO owns (Owns_ID, Team_ID, User_ID, Amount_Owned) VALUES (null, :teamId, :userId, :amountOwned)";

}
