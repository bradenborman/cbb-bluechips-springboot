package Borman.cbbbluechips.utilities;

public class FilteredSearchUtility {

    public static String buildSQL() {
        return  "SELECT * FROM transaction_history WHERE Team_Name in (:tags) order by Transaction_ID desc";
//        return  "SELECT * FROM transaction_history " +
//                "WHERE User_Name in (:tags) " +
//                "OR Team_Name in (:tags) " +
//                "OR Amount_Spent in (:tags)";
    }

//    INSERT INTO transaction_history " +
//            "(User_Name, Team_Name, Volume_Traded, Amount_Spent, Time_of_Trade) " +
//            "VALUES (:fullName, :teamName, :volumeTraded, :cashTraded, :strTimeofTransaction);


    public static String buildSQL(String teamName, String userName) {
        final String base = "SELECT * FROM transaction_history";
        StringBuilder stringBuilder = new StringBuilder();

        if (!(!teamName.equals("") || !userName.equals("")))
            return base;
        else
            stringBuilder.append(base + " WHERE");

        if (!teamName.equals(""))
            stringBuilder.append(" Team_Name = '").append(teamName).append("'");

        if (!teamName.equals("") && !userName.equals(""))
            stringBuilder.append(" AND");

        if (!userName.equals(""))
            stringBuilder.append(" Name = '").append(userName).append("'");

        return stringBuilder.toString();
    }

}
