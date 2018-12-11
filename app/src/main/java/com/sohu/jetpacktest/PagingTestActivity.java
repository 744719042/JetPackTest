package com.sohu.jetpacktest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sohu.jetpacktest.adapter.PagedMovieAdapter;
import com.sohu.jetpacktest.room.entity.MovieEntity;
import com.sohu.jetpacktest.repository.MovieRepository;

public class PagingTestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LiveData<PagedList<MovieEntity>> pagedList;
    private MovieRepository repository;
    private PagedMovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging_test);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new PagedMovieAdapter());
        repository = new MovieRepository();
        pagedList = new LivePagedListBuilder<>(repository.getAllMovies(), new PagedList.Config.Builder()
                .setPageSize(10)
                .setPrefetchDistance(2)
                .setInitialLoadSizeHint(20)
                .build())
                .build();
        pagedList.observe(this, new Observer<PagedList<MovieEntity>>() {
            @Override
            public void onChanged(@Nullable PagedList<MovieEntity> movieEntities) {
                adapter.submitList(movieEntities);
            }
        });
    }
}
