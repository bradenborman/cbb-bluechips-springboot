package com.Borman.cbbbluechips.daos.sql;

public class TeamSQL {

    public static final String getAllTeams = "SELECT * FROM teams order by name asc;";

    public static final String getTournamentTeams = "SELECT * FROM teams WHERE seed > 0 ORDER by is_out ASC, seed asc;";

    public static final String getTeamById = "SELECT * FROM teams WHERE Team_ID = :teamId;";

    public static final String getTeamName = "SELECT Name FROM teams where Team_ID = :teamId;";

    public static final String getSharesOutstanding = "SELECT Sum(Amount_Owned) FROM owns " +
            "Right JOIN teams ON teams.Team_ID = owns.Team_ID " +
            "Where teams.Team_ID = :teamId";

    public static final String getTeamByName = "SELECT * FROM teams WHERE Name = :teamName;";

    public static final String updateNextTeamPlaying = "UPDATE teams SET Next_Team_Playing = :teamPlayingShortName WHERE (Sports_Data_Team_ID = :teamToUpdateId)";
}
