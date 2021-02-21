package com.sofia.mytravelmate.retrofit.datamodel;

import com.google.gson.annotations.SerializedName;

public class SysDto {

    @SerializedName("type")
    private int type;

    @SerializedName("id")
    private long id;

    @SerializedName("message")
    private double message;

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private long sunrise;

    @SerializedName("sunset")
    private long sunset;

    public int getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
