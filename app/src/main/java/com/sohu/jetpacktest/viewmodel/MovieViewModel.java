package com.sohu.jetpacktest.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.sohu.jetpacktest.repository.MovieRepository;
import com.sohu.jetpacktest.room.entity.MovieEntity;

public class MovieViewModel extends ViewModel {
    private LiveData<PagedList<MovieEntity>> pagedList;
    private MovieRepository repository;
    private MutableLiveData<MovieEntity> movieEntity;

    public MovieViewModel() {
        repository = new MovieRepository();
        pagedList = new LivePagedListBuilder<>(repository.getAllMovies(), new PagedList.Config.Builder()
                .setPageSize(10)
                .setPrefetchDistance(2)
                .setInitialLoadSizeHint(20)
                .build())
                .build();
        movieEntity = new MutableLiveData<>();
    }

    public LiveData<PagedList<MovieEntity>> getPagedList() {
        return pagedList;
    }

    public MutableLiveData<MovieEntity> getMovieEntity() {
        return movieEntity;
    }
}
