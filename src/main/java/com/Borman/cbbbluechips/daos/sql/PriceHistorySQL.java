package com.Borman.cbbbluechips.daos.sql;

public class PriceHistorySQL {

    //TODO add order by roundID and create table
    public static final String getTeamById = "SELECT * FROM price_history " +
            "WHERE Team_ID = :teamId;";

    public static final String getTeamPriceByRound = "SELECT * FROM price_history WHERE Team_ID = :teamId AND Round_ID = :round";
}
