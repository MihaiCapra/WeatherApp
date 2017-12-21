package dev.capra.mihai.weatherapp.utils;

/**
 * Created by mihai on 12/20/2017.
 */

public enum WindSpeedPrefs {
    METERS("METERS"),
    MILES("MILES"),
    KM("KM");

    private String speed;

    WindSpeedPrefs(String speed){
        this.speed = speed;
    }

    public String getSpeed(){
        return this.speed;
    }
}
