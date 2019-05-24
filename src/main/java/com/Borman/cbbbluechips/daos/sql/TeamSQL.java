package com.Borman.cbbbluechips.daos.sql;

public class TeamSQL {

    public static final String getAllTeams = "SELECT * FROM teams;";

    public static final String getTournamentTeams = "SELECT * FROM teams WHERE seed > 0 ORDER by is_out ASC, seed asc;";

    public static final String getTeamById = "SELECT * FROM teams WHERE Team_ID = :teamId;";

    public static final String getTeamName = "SELECT Name FROM teams where Team_ID = :teamId;";

}
