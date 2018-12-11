package com.sohu.jetpacktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChangeDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_dialog);
    }

    public void onClosed(View view) {
        finish();
    }

    public void onChangeName(View view) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.sohu.change_value"));
    }
}
