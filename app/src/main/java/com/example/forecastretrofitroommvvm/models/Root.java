package com.example.forecastretrofitroommvvm.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class Root implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long identifier;
    @ColumnInfo(name = "day")
    public String day;
    public String description;
    public int sunrise;
    public int sunset;
    public double chance_rain;
    public int high;
    public int low;
    public String image;

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public Root(String day, String description, int sunrise, int sunset, double chance_rain, int high, int low, String image) {
        this.day = day;
        this.description = description;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.chance_rain = chance_rain;
        this.high = high;
        this.low = low;
        this.image = image;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public double getChance_rain() {
        return chance_rain;
    }

    public void setChance_rain(double chance_rain) {
        this.chance_rain = chance_rain;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
