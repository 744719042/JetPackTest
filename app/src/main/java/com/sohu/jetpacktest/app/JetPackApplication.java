package com.sohu.jetpacktest.app;

import android.app.Application;
import android.content.Context;

import com.sohu.jetpacktest.room.AdsDatabase;

public class JetPackApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        AdsDatabase.init(this);
    }
}
