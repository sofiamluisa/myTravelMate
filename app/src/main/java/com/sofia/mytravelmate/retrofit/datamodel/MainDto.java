package com.sofia.mytravelmate.retrofit.datamodel;

import com.google.gson.annotations.SerializedName;

public class MainDto {

    @SerializedName("temp")
    private double temp;

    @SerializedName("feels_like")
    private double feels_like;

    @SerializedName("temp_min")
    private double temp_min;

    @SerializedName("temp_max")
    private double temp_max;

    @SerializedName("pressure")
    private int pressure;

    @SerializedName("humidity")
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
