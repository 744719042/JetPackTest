package com.sohu.jetpacktest.adapter;

import android.support.v7.widget.RecyclerView;

import com.sohu.jetpacktest.databinding.MovieItemNewBinding;
import com.sohu.jetpacktest.room.entity.MovieEntity;

public class BindingMovieViewHolder extends RecyclerView.ViewHolder {
    private MovieItemNewBinding binding;
    public BindingMovieViewHolder(MovieItemNewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindView(MovieEntity movieEntity) {
        binding.setItem(movieEntity);
        binding.executePendingBindings();
    }
}
