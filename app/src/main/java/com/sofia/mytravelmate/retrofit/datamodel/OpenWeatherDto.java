package com.sofia.mytravelmate.retrofit.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenWeatherDto {

    @SerializedName("coord")
    private CoordDto coord;

    @SerializedName("weather")
    private List<WeatherDto> weather;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private MainDto main;

    @SerializedName("visibility")
    private long visibility;

    @SerializedName("wind")
    private WindDto wind;

    @SerializedName("clouds")
    private CloudsDto clouds;

    @SerializedName("dt")
    private long dt;

    @SerializedName("sys")
    private SysDto sys;

    @SerializedName("timezone")
    private int timezone;

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private int cod;

    public CoordDto getCoord() {
        return coord;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainDto getMain() {
        return main;
    }

    public long getVisibility() {
        return visibility;
    }

    public WindDto getWind() {
        return wind;
    }

    public CloudsDto getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public SysDto getSys() {
        return sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}
