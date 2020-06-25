package com.example.newsapp_java.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.newsapp_java.R;
import com.example.newsapp_java.fragment.adapter.ArticleListAdapter;
import com.example.newsapp_java.viewmodel.ArticleViewModel;


public class ArticleListFragment extends Fragment {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    TextView textView;
    private ArticleViewModel articleViewModel;
    ArticleListAdapter articleListAdapter = new ArticleListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_article_list, container, false);

        recyclerView = root.findViewById(R.id.recArticle);

        articleViewModel = new ViewModelProvider(this)
                .get(ArticleViewModel.class);
        articleViewModel.loadResults();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        articleViewModel.getResults().observe(
                getViewLifecycleOwner(),
                news -> {
                    articleListAdapter.updateArticle(
                            news.getArticles()
                    );
                    articleListAdapter.notifyDataSetChanged();

                }
        );
        setupRecyclerView();

        return root;
    }

    private void setupRecyclerView(){
        recyclerView.setAdapter(articleListAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }
}