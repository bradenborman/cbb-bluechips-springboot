package com.Borman.cbbbluechips.utilities;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class SportsDataDateUtility {

    public static String getTodayDateString() {

        LocalDate date = LocalDate.now();

        String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int day = date.getDayOfMonth();

        
        //TODO hardcoded for testing
        return SECOND_ROUND_2019;

        //return String.format("%s-%s-%s", date.getYear(), month, day);

    }

    private static final String SECOND_ROUND_2019 = "2019-MAR-24";

    private static final String SWEET_SIXTEEN_2019_1 = "2019-MAR-28";

    private static final String SWEET_SIXTEEN_2019_2 = "2019-MAR-29";
    
    
}

