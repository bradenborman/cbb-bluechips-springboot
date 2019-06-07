package com.Borman.cbbbluechips.utilities;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class SportsDataDateUtility {

    public static String getTodayDateString() {

        LocalDate date = LocalDate.now();

        String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int day = date.getDayOfWeek().getValue();

        return String.format("%s-%s-%s", date.getYear(), month, day);

    }

}

