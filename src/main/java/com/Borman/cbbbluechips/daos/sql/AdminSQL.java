package com.Borman.cbbbluechips.daos.sql;

public class AdminSQL {

    public static final String deleteAllTeams = "DELETE FROM teams WHERE Team_ID > 0";

    public static final String insertFromSportsDataAPI = "INSERT INTO teams (Name, Nickname, Is_Out, Seed, Current_Market_Price, Wins, Losses, " +
            "Logo_URL, Short_Display_Name, Sports_Data_Team_ID) VALUES (:school, :name, false, 0, 5000, :wins, :losses, :teamLogoUrl, :shortDisplayName, :teamId);";

    public static final String updateTeamInfo = "UPDATE teams SET Wins = :wins, Losses = :losses, Sports_Data_Team_ID = :teamId WHERE Name = :school";

    public static final String resetSeeds = "UPDATE teams SET seed = '0' WHERE Team_ID > 0";

    public static final String updateSeeds = "UPDATE teams SET seed = :newSeed WHERE Name = :teamName";

    public static final String updateLockedAndEliminated = "UPDATE teams SET Is_Out = :out, Is_Locked = :locked WHERE Name = :teamName";
}
