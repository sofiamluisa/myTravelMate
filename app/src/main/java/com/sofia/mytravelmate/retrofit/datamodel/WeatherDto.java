package com.sofia.mytravelmate.retrofit.datamodel;

import com.google.gson.annotations.SerializedName;

public class WeatherDto {

    @SerializedName("id")
    private long id;

    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
