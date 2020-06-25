package com.example.newsapp_java.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp_java.api.ApiService;
import com.example.newsapp_java.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {

    MutableLiveData<News> results = new  MutableLiveData<>();
    MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<News> getResults() {
        return results;
    }

    public MutableLiveData<Boolean> getLoadError() {
        return loadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void loadResults(){
        loading.setValue(true);

        String apikey = "34500a0a110c4cd19a015b6eb3c9c0ea";
        Call<News> newsCall = ApiService.getNews(
                "technologies", apikey
        );

        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful() && response.body()!= null){
                    loading.setValue(false);
                    results.setValue(response.body());
                    Log.d("article",response.body().toString());
                    loadError.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
               loading.setValue(false);
               loadError.setValue(true);
            }

        });
        }
    }