package com.sohu.jetpacktest.repository;

import android.arch.paging.DataSource;
import android.util.Log;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.room.AdsDatabase;
import com.sohu.jetpacktest.room.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private static final String TAG = "MovieRepository";
    public DataSource.Factory<Integer, MovieEntity> getAllMovies() {
        return AdsDatabase.getInstance().getMovieDao().getAllMovies();
    }
}
