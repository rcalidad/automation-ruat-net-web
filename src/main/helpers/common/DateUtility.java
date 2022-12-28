package main.helpers.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {
    //Return current date with format DD/MM/AAAA
    public static String getCurrentDate(){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
