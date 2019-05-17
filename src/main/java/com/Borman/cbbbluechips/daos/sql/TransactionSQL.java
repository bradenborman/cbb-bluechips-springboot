package com.Borman.cbbbluechips.daos.sql;

public class TransactionSQL {

    public static final String getByTeamName = "SELECT * FROM transaction_history \n" +
            "LEFT JOIN user ON user.User_ID = transaction_history.User_ID \n" +
            "WHERE Team_Name = :teamName;";

    public static final String getByUserId = "SELECT * FROM transaction_history " +
            "WHERE User_ID = :userId;";

    public static final String insertIntoTransactionHistory = "INSERT INTO transaction_history " +
            "(User_ID, Team_ID, Volume_Traded, Amount_Spent) " +
            "VALUES (:userId, :teamName, :volumeTraded, :cashTraded);";


    public static String sellShares = "UPDATE owns SET Amount_Owned = Amount_Owned - :volume WHERE Team_ID = :teamId AND User_ID = :userId;";

}
