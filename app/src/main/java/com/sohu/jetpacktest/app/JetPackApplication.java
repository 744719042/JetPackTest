package com.sohu.jetpacktest.app;

import android.app.Application;

import com.sohu.jetpacktest.room.AdsDatabase;

public class JetPackApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AdsDatabase.init(this);
    }
}
