package com.sohu.jetpacktest.adapter;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.databinding.MovieItemNewBinding;
import com.sohu.jetpacktest.room.entity.MovieEntity;

public class PagedBindingMovieAdapter extends PagedListAdapter<MovieEntity, BindingMovieViewHolder> {
    public interface OnItemClickListener {
        void onClick(MovieEntity entity);
    }

    private OnItemClickListener listener;
    public PagedBindingMovieAdapter(OnItemClickListener listener) {
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
        this.listener = listener;
    }

    @NonNull
    @Override
    public BindingMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MovieItemNewBinding movieItemBinding = DataBindingUtil.inflate(inflater, R.layout.movie_item_new, parent, false);
        movieItemBinding.setListener(listener);
        return new BindingMovieViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingMovieViewHolder holder, int position) {
        holder.bindView(getItem(position));
    }
}
