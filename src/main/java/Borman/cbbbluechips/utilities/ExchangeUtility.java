package Borman.cbbbluechips.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExchangeUtility {


    public static int calculateAvailableCanPurchase(double purchasingPower, double currentMarketPrice) {
        return (int) Math.floor(purchasingPower / currentMarketPrice);
    }

    public static String setStartTimeFormatted(LocalDateTime nextGameTime) {
        if(nextGameTime == null)
            return "Not playing today";
        return nextGameTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }


}