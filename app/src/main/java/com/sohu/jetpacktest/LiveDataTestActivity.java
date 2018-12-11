package com.sohu.jetpacktest;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LiveDataTestActivity extends AppCompatActivity {
    private MutableLiveData<String> name = new MutableLiveData<>();
    private TextView text;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_test);
        text = findViewById(R.id.text);
        text.setText("姓名： 张三" + count++);
        name.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newName) {
                text.setText("姓名：" + newName);
            }
        });

        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                changeName();
            }
        }, new IntentFilter("com.sohu.change_value"));
    }

    public void onChangeName(View view) {
        changeName();
    }

    private void changeName() {
        String newValue = "张三" + (count++);
        Toast.makeText(getApplicationContext(), "设置新值：" + newValue, Toast.LENGTH_SHORT).show();
        name.setValue(newValue);
    }

    public void onShowDialog(View view) {
        Intent intent = new Intent(this, ChangeDialogActivity.class);
        startActivity(intent);
    }
}
