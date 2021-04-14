package Borman.cbbbluechips.daos.sql;

public class GameSettingsSQL {

       public static final String getCurrentRound = "Select Current_Round FROM game_info";

       public static final String updateCurrentRound = "UPDATE game_info SET 'Current_Round' = :round) WHERE Year = '2019';";

}
