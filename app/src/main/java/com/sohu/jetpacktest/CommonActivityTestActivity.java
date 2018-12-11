package com.sohu.jetpacktest;

import android.app.Activity;
import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sohu.jetpacktest.adapter.VerticalAdapter;
import com.sohu.jetpacktest.widget.VerticalScrollView;

public class CommonActivityTestActivity extends Activity implements LifecycleOwner {
    private static final String TAG = "CommonActivityTestActiv";
    private LifecycleRegistry lifecycleRegistry;
    private VerticalScrollView verticalScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifecycleRegistry = new LifecycleRegistry(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_test);
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

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    public void onShowDialog(View view) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }
}
