package com.sohu.jetpacktest.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.databinding.FragmentMovieDetailBinding;
import com.sohu.jetpacktest.room.entity.MovieEntity;
import com.sohu.jetpacktest.viewmodel.MovieViewModel;

import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {

    private FragmentMovieDetailBinding binding;

    public MovieDetailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false);
        binding.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
//                Navigation.findNavController(v).navigate(R.id.gotoList);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MovieViewModel viewModel = ViewModelProviders.of(getActivity()).get(MovieViewModel.class);
        viewModel.getMovieEntity().observe(this, new Observer<MovieEntity>() {
            @Override
            public void onChanged(@Nullable MovieEntity movieEntity) {
                binding.setMovie(movieEntity);
                binding.executePendingBindings();
            }
        });
    }
}
