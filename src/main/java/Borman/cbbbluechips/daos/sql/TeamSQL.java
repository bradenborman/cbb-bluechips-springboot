package Borman.cbbbluechips.daos.sql;

public class TeamSQL {

    public static final String getAllTeams = "SELECT * FROM teams order by name asc;";

    public static final String getTournamentTeams = "SELECT * FROM teams WHERE seed > 0 ORDER by Next_Team_Playing is not null desc, is_out ASC, seed asc;";

    public static final String getTeamById = "SELECT * FROM teams WHERE Team_ID = :teamId;";

    public static final String getTeamName = "SELECT Name FROM teams where Team_ID = :teamId;";

    public static final String getSharesOutstanding = "SELECT Sum(Amount_Owned) FROM owns " +
            "Right JOIN teams ON teams.Team_ID = owns.Team_ID " +
            "Where teams.Team_ID = :teamId";

    public static final String getAllTeamsWithSharesOutstandingDetail = "SELECT teams.Team_ID, name, seed, Is_Locked, point_spread, is_out, Logo_URL, " +
            "Current_Market_Price, Next_Team_Playing, Point_Spread, Sum(Amount_Owned) as Amount_Owned, teams.Name " +
            "FROM teams " +
            "left JOIN owns ON teams.Team_ID = owns.Team_ID " +
            "WHERE seed > 0 group by teams.Team_ID " +
            "ORDER by Next_Team_Playing is not null desc, is_out ASC, seed asc";

    public static final String getTeamByName = "SELECT * FROM teams WHERE Name = :teamName;";

    public static final String updateNextTeamPlaying = "UPDATE teams SET Next_Team_Playing = :teamPlayingShortName WHERE (Sports_Data_Team_ID = :teamToUpdateId)";

    public static final String getTeamPlayingNext = "SELECT Next_Team_Playing FROM teams where Team_ID = :teamId;";

    public static final String resetNextTeamPlayingForAll = "UPDATE teams SET Next_Team_Playing = null, Point_Spread = null";

    public static final String getNextPointSpread = "SELECT Point_Spread FROM teams where Team_ID = :teamId";

    public static final String getNameByShortName = "SELECT Name FROM teams WHERE Short_Display_Name = :teamShortName LIMIT 1";

    public static final String getLockedStatusByTeam = "SELECT Is_Locked FROM teams WHERE Team_ID = :teamId";

}
