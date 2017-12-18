package dev.capra.mihai.weatherapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by mihai on 12/18/2017.
 */

public class Utils {
    public static String getHourMinutes(long unixTimeStamp){
        Date time = new Date(unixTimeStamp * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        return simpleDateFormat.format(time);
    }

    public static String DegreesToCardinal(double degrees)
    {
        String[] caridnals = { "N", "NE", "E", "SE", "S", "SW", "W", "NW", "N" };
        return caridnals[(int)Math.round(((double)degrees % 360) / 45)];
    }

    public static String DegreesToCardinalDetailed(double degrees)
    {
        degrees *= 10;

        String[] caridnals = { "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N" };
        return caridnals[(int)Math.round(((double)degrees % 3600) / 225)];
    }
}
