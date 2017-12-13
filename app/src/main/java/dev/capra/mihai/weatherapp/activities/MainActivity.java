package dev.capra.mihai.weatherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;

import dev.capra.mihai.weatherapp.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        ConstraintLayout layout = findViewById(R.id.main_layout);
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setFillAfter(true);
        animation.setDuration(800);
        layout.startAnimation(animation);
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
}