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
import android.widget.RadioButton;

import com.sohu.jetpacktest.R;
import com.sohu.jetpacktest.entity.Movie;
import com.sohu.jetpacktest.viewmodel.CommunicateViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private RadioButton first;
    private RadioButton second;
    private RadioButton third;
    private Button button;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    private List<Movie> data = new ArrayList<Movie>() {
        {
            add(new Movie(R.drawable.rmdmy,"人民的名义", "中央军委后勤保障部金盾影视中心出品的检察反腐电视剧"));
            add(new Movie(R.drawable.qm,"法医秦明", "法医秦明与法医助理大宝、刑警队大队长林涛屡破要案的故事"));
            add(new Movie(R.drawable.bigbang,"生活大爆炸", "讲述的是四个宅男科学家和一个美女邻居发生的搞笑生活故事"));
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        first = view.findViewById(R.id.first);
        second = view.findViewById(R.id.second);
        third = view.findViewById(R.id.third);

        button = view.findViewById(R.id.showNewFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommunicateViewModel viewModel = ViewModelProviders.of(getActivity()).get(CommunicateViewModel.class);
                viewModel.movie = first.isChecked() ? data.get(0) : second.isChecked() ? data.get(1) : data.get(2);
                getFragmentManager().beginTransaction()
                        .add(R.id.content, new SecondFragment())
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        });
    }
}
