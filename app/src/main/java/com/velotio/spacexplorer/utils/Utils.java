package com.velotio.spacexplorer.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {

    /**
     *  Utility method takes utc time and returns date time
     * @param utc
     * @return date
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getLocalDateTime(String utc) {
        try {
            Instant utcTime = Instant.parse(utc);

            // Define the time zone (Asia/Kolkata)
            ZoneId timeZone = ZoneId.of("Asia/Kolkata");

            // Convert UTC time to local time
            ZonedDateTime localTime = utcTime.atZone(timeZone);

            // Format the local time in the desired format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yy HH:mm:ss", Locale.ENGLISH);
            return localTime.format(formatter);
        }catch (Exception e) {
            return utc;
        }
    }

}
