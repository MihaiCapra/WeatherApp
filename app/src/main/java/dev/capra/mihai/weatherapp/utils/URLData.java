package dev.capra.mihai.weatherapp.utils;

/**
 * Created by mihai on 12/14/2017.
 */

public class URLData {
    public static final String API_KEY = "05e505567127c5911e3b779ab89b98d9";
    public static final String BASE_LINK = "http://api.openweathermap.org/data/2.5/";

    public static String getWeatherLocationQuery(double lat, double lng){
        return "?lat=" + lat + "&lon=" + lng + "&appid=" + API_KEY + "&units=metric";
    }
}
