package com.sohu.jetpacktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LifecycleTestActivity extends AppCompatActivity {
    private static final String TAG = "LifecycleTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_test);
    }

    public void onAppCompat(View view) {
        Intent intent = new Intent(this, AppCompatTestActivity.class);
        startActivity(intent);
    }

    public void onActivity(View view) {
        Intent intent = new Intent(this, CommonActivityTestActivity.class);
        startActivity(intent);
    }
}
