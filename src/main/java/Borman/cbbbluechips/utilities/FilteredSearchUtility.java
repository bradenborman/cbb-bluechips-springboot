package Borman.cbbbluechips.utilities;

public class FilteredSearchUtility {


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
