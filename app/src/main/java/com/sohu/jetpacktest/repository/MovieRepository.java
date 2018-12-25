package com.sohu.jetpacktest.repository;

import android.arch.paging.DataSource;

import com.sohu.jetpacktest.room.AdsDatabase;
import com.sohu.jetpacktest.room.entity.MovieEntity;

public class MovieRepository {
    private static final String TAG = "MovieRepository";
    public DataSource.Factory<Integer, MovieEntity> getAllMovies() {
        return AdsDatabase.getInstance().getMovieDao().getAllMovies();
    }
}
