package dev.capra.mihai.weatherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dev.capra.mihai.weatherapp.utils.DefaultSettings;

/**
 * Created by mihai on 12/13/2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        DefaultSettings.checkSettings();
        finish();
    }
}
