package com.sohu.jetpacktest.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.adapter.PagedBindingMovieAdapter;
import com.sohu.jetpacktest.room.entity.MovieEntity;
import com.sohu.jetpacktest.viewmodel.MovieViewModel;

import androidx.navigation.Navigation;

public class MovieListFragment extends Fragment {

    private RecyclerView recyclerView;
    private PagedBindingMovieAdapter adapter;

    public MovieListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter = new PagedBindingMovieAdapter(new PagedBindingMovieAdapter.OnItemClickListener() {
            @Override
            public void onClick(MovieEntity entity) {
                MovieViewModel viewModel = ViewModelProviders.of(getActivity()).get(MovieViewModel.class);
                viewModel.getMovieEntity().setValue(entity);
                Navigation.findNavController(view).navigate(R.id.gotoDetail);
            }
        }));

        MovieViewModel viewModel = ViewModelProviders.of(getActivity()).get(MovieViewModel.class);
        viewModel.getPagedList().observe(this, new Observer<PagedList<MovieEntity>>() {
            @Override
            public void onChanged(@Nullable PagedList<MovieEntity> movieEntities) {
                adapter.submitList(movieEntities);
            }
        });
    }
}
