package dev.capra.mihai.weatherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private ImageView mCurrentStatusImage;
    private TextView mDay1, mDay2, mDay3, mDay4;
    private ImageView mDay1Icon, mDay2Icon, mDay3Icon, mDay4Icon;
    private TextView mDay1Temp, mDay2Temp, mDay3Temp, mDay4Temp;

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
        mCurrentStatusImage = findViewById(R.id.today_icon);

        LinearLayout linearLayout = findViewById(R.id.horizontal_layout_days);
        //day1
        mDay1 = linearLayout.findViewById(R.id.day1_txt);
        mDay1Icon = linearLayout.findViewById(R.id.day1_icon);
        mDay1Temp = linearLayout.findViewById(R.id.day1_temperature);

        //day2
        mDay2 = linearLayout.findViewById(R.id.day2_txt);
        mDay2Icon = linearLayout.findViewById(R.id.day2_icon);
        mDay2Temp = linearLayout.findViewById(R.id.day2_temperature);

        //day3
        mDay3 = linearLayout.findViewById(R.id.day3_txt);
        mDay3Icon = linearLayout.findViewById(R.id.day3_icon);
        mDay3Temp = linearLayout.findViewById(R.id.day3_temperature);

        //day4
        mDay4 = linearLayout.findViewById(R.id.day4_txt);
        mDay4Icon = linearLayout.findViewById(R.id.day4_icon);
        mDay4Temp = linearLayout.findViewById(R.id.day4_temperature);

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

    private void getWeatherData() {
        Call<WeatherData> call = ApiClient.getOpenWeatherInterface().getWeatherData();

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                mTemp.setText(String.format(Locale.US, "%d °C", response.body().getCurrentTemp()));
                mLoaction.setText(response.body().getCity());
                mCurrentState.setText(response.body().getWeatherDescription());
                mSunriseTime.setText(Utils.getHourMinutes(response.body().getSunrise()));
                mSunsetTime.setText(Utils.getHourMinutes(response.body().getSunset()));
                mMinMaxTemp.setText(String.format("%s...%s",
                        response.body().getMinTemp(), response.body().getMaxTemp()));
                mWindSpeed.setText(String.format(Locale.US, "%.1f m/s", response.body().getWindSpeed()));
                mWindDirection.setText(Utils.DegreesToCardinalDetailed(response.body().getWindDirection()));
                Utils.loadImageWithGlide(MainActivity.this, mCurrentStatusImage, String.format("w_%s", response.body().getWeatherIcon()));

                mDay1.setText(Utils.getWeekDay(response.body().getNextDays().get(0).getDay()));
                Utils.loadImageWithGlide(MainActivity.this, mDay1Icon, String.format("w_%s", response.body().getNextDays().get(0).getIcon()));
                mDay1Temp.setText(String.format(
                        Locale.US,"%d...%d",
                        response.body().getNextDays().get(0).getMinTemp().intValue(),
                        response.body().getNextDays().get(0).getMaxTemp().intValue()));

                mDay2.setText(Utils.getWeekDay(response.body().getNextDays().get(1).getDay()));
                Utils.loadImageWithGlide(MainActivity.this, mDay2Icon, String.format("w_%s", response.body().getNextDays().get(1).getIcon()));
                mDay2Temp.setText(String.format(
                        Locale.US, "%d...%d",
                        response.body().getNextDays().get(1).getMinTemp().intValue(),
                        response.body().getNextDays().get(1).getMaxTemp().intValue()));

                mDay3.setText(Utils.getWeekDay(response.body().getNextDays().get(2).getDay()));
                Utils.loadImageWithGlide(MainActivity.this, mDay3Icon, String.format("w_%s", response.body().getNextDays().get(2).getIcon()));
                mDay3Temp.setText(String.format(
                        Locale.US, "%d...%d",
                        response.body().getNextDays().get(2).getMinTemp().intValue(),
                        response.body().getNextDays().get(2).getMaxTemp().intValue()));

                mDay4.setText(Utils.getWeekDay(response.body().getNextDays().get(3).getDay()));
                Utils.loadImageWithGlide(MainActivity.this, mDay4Icon, String.format("w_%s", response.body().getNextDays().get(3).getIcon()));
                mDay4Temp.setText(String.format(
                        Locale.US, "%d...%d",
                        response.body().getNextDays().get(3).getMinTemp().intValue(),
                        response.body().getNextDays().get(3).getMaxTemp().intValue()));
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadResponseInUi(Response<WeatherData> response) {
        mTemp.setText(String.format(Locale.US, "%d °C", response.body().getCurrentTemp()));
        mLoaction.setText(response.body().getCity());
        mCurrentState.setText(response.body().getWeatherDescription());
        mSunriseTime.setText(Utils.getHourMinutes(response.body().getSunrise()));
        mSunsetTime.setText(Utils.getHourMinutes(response.body().getSunset()));
        mMinMaxTemp.setText(String.format("%s...%s",
                response.body().getMinTemp(), response.body().getMaxTemp()));
        mWindSpeed.setText(String.format(Locale.US, "%.1f m/s", response.body().getWindSpeed()));
        mWindDirection.setText(Utils.DegreesToCardinalDetailed(response.body().getWindDirection()));

        mDay1.setText(response.body().getNextDays().get(1).getDay());
        mDay1Icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cloudyday));
        mDay1Temp.setText(String.format("%s...%s", response.body().getNextDays().get(1).getMinTemp(), response.body().getNextDays().get(1).getMaxTemp()));

        mDay2.setText(response.body().getNextDays().get(2).getDay());
        mDay2Icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cloudyday));
        mDay2Temp.setText(String.format("%s...%s", response.body().getNextDays().get(2).getMinTemp(), response.body().getNextDays().get(2).getMaxTemp()));

        mDay3.setText(response.body().getNextDays().get(3).getDay());
        mDay3Icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cloudyday));
        mDay3Temp.setText(String.format("%s...%s", response.body().getNextDays().get(3).getMinTemp(), response.body().getNextDays().get(3).getMaxTemp()));

        mDay4.setText(response.body().getNextDays().get(4).getDay());
        mDay4Icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cloudyday));
        mDay4Temp.setText(String.format("%s...%s", response.body().getNextDays().get(3).getMinTemp(), response.body().getNextDays().get(4).getMaxTemp()));
    }
}