package com.test_project.mycanteentest.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConfig {

    private String URL = "http://fpandroid3.000webhostapp.com/API/";
//    private String URL = "https://penjualanapi.000webhostapp.com/API/";

    private Retrofit retrofit;

    public ApiService createService(){
        retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }

}
