package com.example.newsapp_java.api;

import com.example.newsapp_java.model.News;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://newsapi.org/v2/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(String BASE_URL){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
            return retrofit;
    }

//    public static ApiInterface apiInterface(){
//        return ApiClient.getApiClient().create(ApiInterface.class);
//    }
}
