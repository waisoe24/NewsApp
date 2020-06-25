package com.example.newsapp_java.api;

import com.example.newsapp_java.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("everything")
    Call<News> getNews(
            @Query("q") String keyWord,
            @Query("apikey") String apiKey
    );
}
