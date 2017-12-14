package dev.capra.mihai.weatherapp.network;

import dev.capra.mihai.weatherapp.interfaces.OpenWeatherInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mihai on 12/14/2017.
 */

public class ApiClient {
    private static OpenWeatherInterface mOpenWetherInterface;
    private static final String URL = "http://lebo.md/";

    public static OpenWeatherInterface getOpenWeatherInterface(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mOpenWetherInterface = retrofit.create(OpenWeatherInterface.class);
        return mOpenWetherInterface;
    }
}
