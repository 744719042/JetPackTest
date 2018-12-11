package com.sohu.jetpacktest;

import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sohu.jetpacktest.viewmodel.TestViewModel;

public class ViewModelRotateActivity extends AppCompatActivity {

    private String name;
    private TestViewModel viewModel;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_rotate);
        text = findViewById(R.id.text);
        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(viewModel.name)) {
            Toast.makeText(this, "name = " + name + ", viewModel.name = " + viewModel.name, Toast.LENGTH_LONG).show();
        }
    }

    public void saveName(View view) {
        name = text.getText().toString();
        viewModel.name = name;
        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(viewModel.name)) {
            Toast.makeText(this, "name = " + name + ", viewModel.name = " + viewModel.name, Toast.LENGTH_LONG).show();
        }
    }

    public void rotatePortrait(View view) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void rotateLandscape(View view) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
