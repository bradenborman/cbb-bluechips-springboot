package com.Borman.cbbbluechips.daos.sql;

public class AdminSQL {

    public static final String deleteAllTeams = "DELETE FROM teams WHERE Team_ID > 0";


    public static final String insertFromSportsDataAPI = "INSERT INTO teams (Name, Nickname, Is_Out, Seed, Current_Market_Price, Wins, Losses, " +
            "Logo_URL, Short_Display_Name, Sports_Data_Team_ID) VALUES (:school, :name, false, 0, 5000, :wins, :losses, :teamLogoUrl, :shortDisplayName, :teamId);";


}
