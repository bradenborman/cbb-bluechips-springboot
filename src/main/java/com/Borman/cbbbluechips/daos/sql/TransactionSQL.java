package com.Borman.cbbbluechips.daos.sql;

public class TransactionSQL {

    public static final String getByTeamName = "SELECT * FROM transaction_history " +
            "WHERE Team_Name = :teamName;";

    public static final String getByUserId = "SELECT * FROM transaction_history " +
            "WHERE TEAM_ID = :userId;";

}
