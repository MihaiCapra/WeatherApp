package dev.capra.mihai.weatherapp.activities;

import android.os.Bundle;

import dev.capra.mihai.weatherapp.R;

/**
 * Created by mihai on 12/13/2017.
 */

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.about_toolbar_title);
    }

    @Override
    protected int getLayoutId() { return R.layout.activity_about; }
}