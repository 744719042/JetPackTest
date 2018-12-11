package com.sohu.jetpacktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewModelTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_test);
    }

    public void testViewModel(View view) {
        Intent intent = new Intent(this, ViewModelRotateActivity.class);
        startActivity(intent);
    }

    public void communicate(View view) {
        Intent intent = new Intent(this, ViewModelCommunicateActivity.class);
        startActivity(intent);
    }
}
