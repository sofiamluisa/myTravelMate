package com.sofia.mytravelmate.retrofit.datamodel;

import com.google.gson.annotations.SerializedName;

public class WindDto {

    @SerializedName("speed")
    private double temp;

    @SerializedName("deg")
    private int deg;

    public double getTemp() {
        return temp;
    }

    public int getDeg() {
        return deg;
    }
}
