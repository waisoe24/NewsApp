package com.example.newsapp_java.api;

import android.util.Log;

import com.example.newsapp_java.model.News;

import retrofit2.Call;

public class ApiService {

    public static final String BASE_URL = "https://newsapi.org/v2/";
//    public static final String Login_URL = "http://";

    public static ApiInterface apiInterface = getApi();

    public static ApiInterface getApi(){
       apiInterface = ApiClient.getApiClient(BASE_URL)
               .create(ApiInterface.class);
       return apiInterface;
    }

    public static Call<News> getNews(String query, String apiKey){

        Log.d("new>>>>>",query);
        return apiInterface.getNews(query, apiKey);


    }

//    public static ApiInterface getLoginApi(){
//        return ApiClient.getApiClient(Login_URL)
//                .create(ApiInterface.class);
//    }

}
