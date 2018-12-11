package com.sohu.jetpacktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sohu.jetpacktest.fragment.FirstFragment;

public class ViewModelCommunicateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_communicate);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, new FirstFragment())
                .commitAllowingStateLoss();
    }
}
