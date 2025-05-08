package com.example.dubaothoitiet;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    public static String BASE_URL = "https://dataservice.accuweather.com";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=fkagWzqGXcj1yFSP0wUBivdJI1VL6cdK&language=vi-vn&metric=true")
    Call<List<Wheather>> getHour();
}