package com.sohu.jetpacktest.room.dao;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sohu.jetpacktest.room.entity.MovieEntity;

@Dao
public interface MovieDao {
    @Insert
    void save(MovieEntity entity);

    @Query("select * from tb_movie")
    DataSource.Factory<Integer, MovieEntity> getAllMovies();
}
