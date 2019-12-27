package com.Borman.cbbbluechips.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentTimeStampUtility {

    public static String getDate() {
        return LocalDateTime.now().minusHours(6).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }


    public static String getTime() {
       return LocalDateTime.now().minusHours(6).format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

}
