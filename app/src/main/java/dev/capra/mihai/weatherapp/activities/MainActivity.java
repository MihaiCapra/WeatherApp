package dev.capra.mihai.weatherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import java.util.Locale;

import dev.capra.mihai.weatherapp.R;
import dev.capra.mihai.weatherapp.models.WeatherData;
import dev.capra.mihai.weatherapp.network.ApiClient;
import dev.capra.mihai.weatherapp.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private TextView mTemp;
    private TextView mLoaction;
    private TextView mCurrentState;
    private TextView mSunriseTime;
    private TextView mSunsetTime;
    private TextView mMinMaxTemp;
    private TextView mWindSpeed;
    private TextView mWindDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTemp = findViewById(R.id.temperature);
        mLoaction = findViewById(R.id.location);
        mCurrentState = findViewById(R.id.today_text);
        mSunriseTime = findViewById(R.id.sunrise_time);
        mSunsetTime = findViewById(R.id.sunset_time);
        mMinMaxTemp = findViewById(R.id.today_min_max_temp_txt);
        mWindSpeed = findViewById(R.id.wind_speed_txt);
        mWindDirection = findViewById(R.id.wind_direction);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        ConstraintLayout layout = findViewById(R.id.main_layout);
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setFillAfter(true);
        animation.setDuration(800);
        layout.startAnimation(animation);
        getWeatherData();
    }

    @Override
    protected String getToolbarTitle() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {

        } else if (id == R.id.action_settings) {
            Intent s = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(s);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

        } else if (id == R.id.action_about) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
        }
        return super.onOptionsItemSelected(item);
    }

    private void getWeatherData(){
        Call<WeatherData> call = ApiClient.getOpenWeatherInterface().getWeatherData();

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                mTemp.setText(String.format(Locale.US, "%d °C",response.body().getCurrentTemp()));
                mLoaction.setText(response.body().getCity());
                mCurrentState.setText(response.body().getWeatherDescription());
                mSunriseTime.setText(Utils.getHourMinutes(response.body().getSunrise()));
                mSunsetTime.setText(Utils.getHourMinutes(response.body().getSunset()));
                mMinMaxTemp.setText(String.format("%s...%s",
                        response.body().getMinTemp(),response.body().getMaxTemp()));
                mWindSpeed.setText(String.format(Locale.US,"%.1f m/s",response.body().getWindSpeed()));
                mWindDirection.setText(Utils.DegreesToCardinalDetailed(response.body().getWindDirection()));
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }
}