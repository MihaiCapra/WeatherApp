package dev.capra.mihai.weatherapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import dev.capra.mihai.weatherapp.wapp.WeatherApplication;

/**
 * Created by mihai on 12/20/2017.
 */

public class DefaultSettings {

    private static final String sPREFS_NAME = "PREF_SETTINGS";

    private static final SharedPreferences preferences = WeatherApplication.getInstance().
            getApplicationContext().getSharedPreferences(sPREFS_NAME, Context.MODE_PRIVATE);
    private static final SharedPreferences.Editor editor = preferences.edit();

    public static void checkSettings() {
        if (!preferences.contains("settingSet")) {
            defaultSettings();
        }
    }

    private static void defaultSettings() {
        editor.putBoolean("settingSet", true);
        editor.putString("TemperaturePref", TemperaturePrefs.CELSIUS.getTemperaturePrefs());
        editor.putString("WindSpeedPref", WindSpeedPrefs.METERS.getSpeed());
        editor.apply();
    }

    public static SharedPreferences getPreferences() {
        return preferences;
    }

    public static String getTemperaturePref() {
        return preferences.getString("TemperaturePref", "");
    }

    public static String getWindSpeedPref() {
        return preferences.getString("WindSpeedPref", "");
    }
}
