package Borman.cbbbluechips.daos.sql;

public class TransactionSQL {

    public static final String getByTeamName = "SELECT * FROM transaction_history \n" +
            "LEFT JOIN user ON user.User_ID = transaction_history.User_ID \n" +
            "WHERE Team_Name = :teamName;";

    public static final String getByUserId = "SELECT * FROM transaction_history " +
            "WHERE User_Name = :userName;";

    public static final String insertIntoTransactionHistory = "INSERT INTO transaction_history " +
            "(User_Name, Team_Name, Volume_Traded, Amount_Spent, Time_of_Trade) " +
            "VALUES (:fullName, :teamName, :volumeTraded, :cashTraded, :strTimeofTransaction);";

    public static final String sellShares = "UPDATE owns SET Amount_Owned = Amount_Owned - :volume " +
            "WHERE Team_ID = :teamId AND User_ID = :userId;";

    public static final String buySharesAgain = "UPDATE owns SET Amount_Owned = Amount_Owned + :volume " +
            "WHERE Team_ID = :teamId AND User_ID = :userId;";

    public static final String buyShares = "INSERT INTO owns (Team_ID, User_ID, Amount_Owned) VALUES (:teamId, :userId, :volume)";

    public static final String getCountTotalTransactions = "SELECT count(Transaction_ID) FROM transaction_history";

    public static final String getAllTransactions = "SELECT * FROM transaction_history";

    public static final String deleteUsersTransactions = "DELETE FROM transaction_history WHERE User_Name = :fullName;";

    public static final String getLatest50Transactions = "SELECT * FROM transaction_history order by Transaction_ID desc LIMIT 50";

    public static final String getTransactions = "SELECT * FROM transaction_history order by Transaction_ID desc";

}
