package com.sohu.jetpacktest;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sohu.jetpacktest.adapter.VerticalAdapter;
import com.sohu.jetpacktest.widget.VerticalScrollView;

public class AppCompatTestActivity extends AppCompatActivity {
    private static final String TAG = "AppCompatTestActivity";
    private VerticalScrollView verticalScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_compat_test);
        verticalScrollView = findViewById(R.id.verticalScrollView);
        verticalScrollView.setAdapter(new VerticalAdapter(this));
        getLifecycle().addObserver(new DefaultLifecycleObserver() {
            @Override
            public void onCreate(@NonNull LifecycleOwner owner) {
                Log.e(TAG, "onCreate");
            }

            @Override
            public void onStart(@NonNull LifecycleOwner owner) {
                Log.e(TAG, "onStart");
            }

            @Override
            public void onResume(@NonNull LifecycleOwner owner) {
                Log.e(TAG, "onResume");
            }

            @Override
            public void onPause(@NonNull LifecycleOwner owner) {
                Log.e(TAG, "onPause");
            }

            @Override
            public void onStop(@NonNull LifecycleOwner owner) {
                Log.e(TAG, "onStop");
            }

            @Override
            public void onDestroy(@NonNull LifecycleOwner owner) {
                Log.e(TAG, "onDestroy");
            }
        });
    }

    public void onShowDialog(View view) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }
}
