package dev.capra.mihai.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("current_temp")
    @Expose
    private Integer currentTemp;
    @SerializedName("sunrise")
    @Expose
    private Integer sunrise;
    @SerializedName("sunset")
    @Expose
    private Integer sunset;
    @SerializedName("weather_description")
    @Expose
    private String weatherDescription;
    @SerializedName("weather_icon")
    @Expose
    private String weatherIcon;
    @SerializedName("min_temp")
    @Expose
    private Double minTemp;
    @SerializedName("max_temp")
    @Expose
    private Double maxTemp;
    @SerializedName("wind_speed")
    @Expose
    private Double windSpeed;
    @SerializedName("wind_direction")
    @Expose
    private Integer windDirection;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("day_1")
    @Expose
    private Integer day1;
    @SerializedName("icon_1")
    @Expose
    private String icon1;
    @SerializedName("type_1")
    @Expose
    private String type1;
    @SerializedName("min_temp_1")
    @Expose
    private Double minTemp1;
    @SerializedName("max_temp_1")
    @Expose
    private Double maxTemp1;
    @SerializedName("day_2")
    @Expose
    private Integer day2;
    @SerializedName("icon_2")
    @Expose
    private String icon2;
    @SerializedName("type_2")
    @Expose
    private String type2;
    @SerializedName("min_temp_2")
    @Expose
    private Double minTemp2;
    @SerializedName("max_temp_2")
    @Expose
    private Double maxTemp2;
    @SerializedName("day_3")
    @Expose
    private Integer day3;
    @SerializedName("icon_3")
    @Expose
    private String icon3;
    @SerializedName("type_3")
    @Expose
    private String type3;
    @SerializedName("min_temp_3")
    @Expose
    private Double minTemp3;
    @SerializedName("max_temp_3")
    @Expose
    private Double maxTemp3;
    @SerializedName("day_4")
    @Expose
    private Integer day4;
    @SerializedName("icon_4")
    @Expose
    private String icon4;
    @SerializedName("type_4")
    @Expose
    private String type4;
    @SerializedName("min_temp_4")
    @Expose
    private Double minTemp4;
    @SerializedName("max_temp_4")
    @Expose
    private Double maxTemp4;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Integer currentTemp) {
        this.currentTemp = currentTemp;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getDay1() {
        return day1;
    }

    public void setDay1(Integer day1) {
        this.day1 = day1;
    }

    public String getIcon1() {
        return icon1;
    }

    public void setIcon1(String icon1) {
        this.icon1 = icon1;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public Double getMinTemp1() {
        return minTemp1;
    }

    public void setMinTemp1(Double minTemp1) {
        this.minTemp1 = minTemp1;
    }

    public Double getMaxTemp1() {
        return maxTemp1;
    }

    public void setMaxTemp1(Double maxTemp1) {
        this.maxTemp1 = maxTemp1;
    }

    public Integer getDay2() {
        return day2;
    }

    public void setDay2(Integer day2) {
        this.day2 = day2;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Double getMinTemp2() {
        return minTemp2;
    }

    public void setMinTemp2(Double minTemp2) {
        this.minTemp2 = minTemp2;
    }

    public Double getMaxTemp2() {
        return maxTemp2;
    }

    public void setMaxTemp2(Double maxTemp2) {
        this.maxTemp2 = maxTemp2;
    }

    public Integer getDay3() {
        return day3;
    }

    public void setDay3(Integer day3) {
        this.day3 = day3;
    }

    public String getIcon3() {
        return icon3;
    }

    public void setIcon3(String icon3) {
        this.icon3 = icon3;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public Double getMinTemp3() {
        return minTemp3;
    }

    public void setMinTemp3(Double minTemp3) {
        this.minTemp3 = minTemp3;
    }

    public Double getMaxTemp3() {
        return maxTemp3;
    }

    public void setMaxTemp3(Double maxTemp3) {
        this.maxTemp3 = maxTemp3;
    }

    public Integer getDay4() {
        return day4;
    }

    public void setDay4(Integer day4) {
        this.day4 = day4;
    }

    public String getIcon4() {
        return icon4;
    }

    public void setIcon4(String icon4) {
        this.icon4 = icon4;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public Double getMinTemp4() {
        return minTemp4;
    }

    public void setMinTemp4(Double minTemp4) {
        this.minTemp4 = minTemp4;
    }

    public Double getMaxTemp4() {
        return maxTemp4;
    }

    public void setMaxTemp4(Double maxTemp4) {
        this.maxTemp4 = maxTemp4;
    }

}