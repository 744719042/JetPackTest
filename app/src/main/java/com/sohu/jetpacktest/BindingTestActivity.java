package com.sohu.jetpacktest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sohu.jetpacktest.databinding.ActivityBindingTestBinding;
import com.sohu.jetpacktest.entity.Employee;

public class BindingTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_test);
        binding.setEmployee(new Employee(R.drawable.image,"张三", "134888888888", 1, "北京市海淀区中关村", "8888888@qq.com"));
    }
}
