package dev.capra.mihai.weatherapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import dev.capra.mihai.weatherapp.R;

/**
 * Created by mihai on 12/13/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getToolbarTitle());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected abstract String getToolbarTitle();
    protected abstract int getLayoutId();
}
