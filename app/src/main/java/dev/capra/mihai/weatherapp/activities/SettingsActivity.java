package dev.capra.mihai.weatherapp.activities;

import android.os.Bundle;
import android.widget.RadioGroup;

import dev.capra.mihai.weatherapp.R;
import dev.capra.mihai.weatherapp.utils.DefaultSettings;
import dev.capra.mihai.weatherapp.utils.TemperaturePrefs;
import dev.capra.mihai.weatherapp.utils.WindSpeedPrefs;

/**
 * Created by mihai on 12/13/2017.
 */

public class SettingsActivity extends BaseActivity {

    private RadioGroup temperaturePrefs;
    private RadioGroup windSpeedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        temperaturePrefs = findViewById(R.id.radio_group_temperature_pref);
        temperaturePrefs.setOnCheckedChangeListener(new onCheckedListenerTemperature());
        windSpeedPref = findViewById(R.id.wind_Speed_radio_prefs);
        windSpeedPref.setOnCheckedChangeListener(new onCheckedListenerWindSpeed());
        loadUiTemp();
        if(DefaultSettings.getWindSpeedPref().equals("METERS")){
            windSpeedPref.check(R.id.wind_ms);
        }
        else if(DefaultSettings.getWindSpeedPref().equals("MILES")){
            windSpeedPref.check(R.id.wind_mph);
        }
        else{
            windSpeedPref.check(R.id.wind_kmph);
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.settings_toolbar_title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    private class onCheckedListenerTemperature implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.celsius_radio:
                    DefaultSettings.getPreferences().edit()
                            .putString(
                                    "TemperaturePref",
                                    TemperaturePrefs.CELSIUS.getTemperaturePrefs()).apply();
                    break;
                case R.id.kelvin_radio:
                    DefaultSettings.getPreferences().edit()
                            .putString(
                                    "TemperaturePref",
                                    TemperaturePrefs.KELVIN.getTemperaturePrefs()).apply();
                    break;
                case R.id.f_radio:
                    DefaultSettings.getPreferences().edit()
                            .putString(
                                    "TemperaturePref",
                                    TemperaturePrefs.F.getTemperaturePrefs()).apply();
                    break;
            }
        }
    }

    private class onCheckedListenerWindSpeed implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.wind_ms:
                    DefaultSettings.getPreferences().edit()
                            .putString(
                                    "WindSpeedPref",
                                    WindSpeedPrefs.METERS.getSpeed()).apply();
                    break;
                case R.id.wind_kmph:
                    DefaultSettings.getPreferences().edit()
                            .putString(
                                    "WindSpeedPref",
                                    WindSpeedPrefs.KM.getSpeed()).apply();
                    break;
                case R.id.wind_mph:
                    DefaultSettings.getPreferences().edit()
                            .putString(
                                    "WindSpeedPref",
                                    WindSpeedPrefs.MILES.getSpeed()).apply();
                    break;
            }
        }
    }

    private void loadUiTemp(){
        if(DefaultSettings.getTemperaturePref().equals("CELSIUS")){
            temperaturePrefs.check(R.id.celsius_radio);
        }
        else if(DefaultSettings.getTemperaturePref().equals("KELVIN")){
            temperaturePrefs.check(R.id.kelvin_radio);
        }
        else{
            temperaturePrefs.check(R.id.f_radio);
        }
    }

    private void loadUiWindSpeed(){
        if(DefaultSettings.getWindSpeedPref().equals("METERS")){
            windSpeedPref.check(R.id.wind_ms);
        }
        else if(DefaultSettings.getWindSpeedPref().equals("MILES")){
            windSpeedPref.check(R.id.wind_mph);
        }
        else{
            windSpeedPref.check(R.id.wind_kmph);
        }
    }
}