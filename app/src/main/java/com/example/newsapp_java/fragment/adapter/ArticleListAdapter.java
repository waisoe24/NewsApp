package com.example.newsapp_java.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp_java.R;
import com.example.newsapp_java.model.ArticlesItem;
import com.example.newsapp_java.model.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>{

    private List<ArticlesItem> articleItems = new ArrayList<ArticlesItem>();

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_list,parent,false);
        return new ArticleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(articleItems.get(position).getTitle());
        Picasso.get()
                .load(articleItems.get(position).getUrlToImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return articleItems.size();
    }

    public void updateArticle(List<ArticlesItem> articleItems){
        this.articleItems= articleItems;
        notifyDataSetChanged();
    }


    //binding
    class ArticleViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView imageView;
        public ArticleViewHolder(@NonNull View itemView){
            super(itemView);
            this.title = itemView.findViewById(R.id.articleTitle);
            this.imageView = itemView.findViewById(R.id.articleImage);
        }
    }

}
