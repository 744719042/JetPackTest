package com.sohu.jetpacktest.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.room.entity.MovieEntity;

public class PagedMovieAdapter extends PagedListAdapter<MovieEntity, MovieViewHolder> {
    public PagedMovieAdapter() {
        super(new DiffUtil.ItemCallback<MovieEntity>() {
            @Override
            public boolean areItemsTheSame(MovieEntity oldItem, MovieEntity newItem) {
                return TextUtils.equals(oldItem.getName(), newItem.getName());
            }

            @Override
            public boolean areContentsTheSame(MovieEntity oldItem, MovieEntity newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bindView(getItem(position));
    }
}
