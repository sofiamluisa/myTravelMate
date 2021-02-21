package com.sofia.mytravelmate.retrofit;

import com.sofia.mytravelmate.retrofit.datamodel.OpenWeatherDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetWeatherService {

    @GET("/data/2.5/weather")
    Call<OpenWeatherDto> getWeather(@Query("q") String city, @Query("appid") String apiKey);

}
