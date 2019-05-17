package com.Borman.cbbbluechips.daos.sql;

public class TeamSQL {

    public static final String getAllTeams = "SELECT * FROM teams;";

    public static final String getTeamById = "SELECT * FROM teams WHERE Team_ID = :teamId;";

}
