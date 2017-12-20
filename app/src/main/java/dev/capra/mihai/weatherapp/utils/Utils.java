package dev.capra.mihai.weatherapp.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by mihai on 12/18/2017.
 */

public class Utils {
    public static String getHourMinutes(long unixTimeStamp) {
        Date time = new Date(unixTimeStamp * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        return simpleDateFormat.format(time);
    }

    public static String DegreesToCardinal(double degrees) {
        String[] caridnals = {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"};
        return caridnals[(int) Math.round((degrees % 360) / 45)];
    }

    public static String DegreesToCardinalDetailed(double degrees) {
        degrees *= 10;

        String[] caridnals = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};
        return caridnals[(int) Math.round((degrees % 3600) / 225)];
    }

    private static String getStringWeekDay(int index) {
        String[] days = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[index-1];
    }

    public static String getWeekDay(long unixTimeStamp) {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(unixTimeStamp * 1000);
        return getStringWeekDay(date.get(Calendar.DAY_OF_WEEK));
    }

    public static void loadImageWithGlide(Context context, ImageView imageView, String name){
        Glide.with(context).load(getImage(context, name)).into(imageView);
    }

    private static int getImage(Context context, String name){
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }
}
