package com.sohu.jetpacktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRoomClick(View view) {
        Intent intent = new Intent(this, RoomActivity.class);
        startActivity(intent);
    }

    public void onPagingClick(View view) {

    }

    public void onLifecycleClick(View view) {
        Intent intent = new Intent(this, LifecycleTestActivity.class);
        startActivity(intent);
    }

    public void onViewModelClick(View view) {
        Intent intent = new Intent(this, ViewModelTestActivity.class);
        startActivity(intent);
    }

    public void onLiveDataClick(View view) {
        Intent intent = new Intent(this, LiveDataTestActivity.class);
        startActivity(intent);
    }

    public void onBindingClick(View view) {

    }
}
