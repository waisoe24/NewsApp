package com.example.newsapp_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.newsapp_java.api.ApiService;
import com.example.newsapp_java.model.ArticlesItem;
import com.example.newsapp_java.model.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    News news;
//    String errorMessage;
//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.txtTest);
//       loadNews();
    }

//    public void loadNews(){
//        String apikey = "34500a0a110c4cd19a015b6eb3c9c0ea";
//        Call<News> newsCall = ApiService.getNews(
//                "technology", apikey
//        );
//
//        newsCall.enqueue(new Callback<News>() {
//            @Override
//            public void onResponse(Call<News> call, Response<News> response) {
//                if(response.isSuccessful() && response.body()!= null){
//                    news = response.body();
//                    textView.setText(news.getArticles().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<News> call, Throwable t) {
//                errorMessage = t.toString();
//
//            }
//
//        });
//  }
}