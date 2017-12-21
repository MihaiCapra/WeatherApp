package dev.capra.mihai.weatherapp.utils;

/**
 * Created by mihai on 12/20/2017.
 */

public enum TemperaturePrefs {
    CELSIUS("CELSIUS"),
    KELVIN("KELVIN"),
    F("F");

    private String temp;


    TemperaturePrefs(String temp) {
        this.temp = temp;
    }

    public String getTemperaturePrefs(){
        return this.temp;
    }

}
