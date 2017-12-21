package dev.capra.mihai.weatherapp.wapp;

import android.app.Application;

/**
 * Created by mihai on 12/20/2017.
 */

public class WeatherApplication extends Application{
    private static WeatherApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized WeatherApplication getInstance(){
        return mInstance;
    }
}
