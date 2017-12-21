package dev.capra.mihai.weatherapp.network;

import dev.capra.mihai.weatherapp.interfaces.OpenWeatherInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mihai on 12/14/2017.
 */

public class ApiClient {
    private static OpenWeatherInterface mOpenWetherInterface;
    private static final String URL = "http://37.233.24.139:80/";

    public static OpenWeatherInterface getOpenWeatherInterface(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        mOpenWetherInterface = retrofit.create(OpenWeatherInterface.class);
        return mOpenWetherInterface;
    }
}
