package dev.capra.mihai.weatherapp.interfaces;

import dev.capra.mihai.weatherapp.models.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mihai on 12/14/2017.
 */

public interface OpenWeatherInterface {
    @GET("weather.json")
    Call<WeatherData> getWeatherData();
}
