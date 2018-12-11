package com.sohu.jetpacktest.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.entity.Movie;
import com.sohu.jetpacktest.viewmodel.CommunicateViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private ImageView imageView;
    private TextView name;
    private TextView description;
    private Button back;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.image);
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
        back = view.findViewById(R.id.back);

        CommunicateViewModel viewModel = ViewModelProviders.of(getActivity()).get(CommunicateViewModel.class);
        Movie movie = viewModel.movie;
        imageView.setImageResource(movie.getPortrait());
        name.setText(movie.getName());
        description.setText(movie.getDescription());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
