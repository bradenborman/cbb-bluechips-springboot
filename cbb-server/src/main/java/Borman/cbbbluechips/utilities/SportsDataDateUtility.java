package Borman.cbbbluechips.utilities;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Predicate;

public class SportsDataDateUtility {

    static Predicate<LocalDate> isPastSeasonStart = (today) -> today.isAfter(LocalDate.of(today.getYear(), Month.NOVEMBER, 25));
    static Predicate<LocalDate> isBeforeOffSeason = (today) -> today.isBefore(LocalDate.of(today.getYear(), Month.MAY, 1));

    public static String getTodayDateString() {

        LocalDate date = LocalDate.now();
        String month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int day = date.getDayOfMonth();

        return SECOND_ROUND_2019;
        //TODO test data!
//        return String.format("%s-%s-%s", date.getYear(), month, day);

//        return isPastSeasonStart
//                .and(isBeforeOffSeason)
//                .test(date) ? String.format("%s-%s-%s", date.getYear(), month, day) : SWEET_SIXTEEN_2019_1;
    }

    private static final String SECOND_ROUND_2019 = "2019-MAR-24";

    private static final String SWEET_SIXTEEN_2019_1 = "2019-MAR-28";

    private static final String SWEET_SIXTEEN_2019_2 = "2019-MAR-29";


}

