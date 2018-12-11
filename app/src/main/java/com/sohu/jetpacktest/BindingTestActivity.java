package com.sohu.jetpacktest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sohu.jetpacktest.databinding.ActivityBindingTestBinding;
import com.sohu.jetpacktest.entity.Employee;

public class BindingTestActivity extends AppCompatActivity {
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_test);
        employee = new Employee(R.drawable.image,"张三", "134888888888", true, "北京市海淀区中关村", "8888888@qq.com");
        binding.setEmployee(employee);
        binding.setPresenter(new Presenter());

        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                employee.setName("Hello World");
            }
        }, new IntentFilter("com.sohu.change_value"));
    }

    public class Presenter {
        public void changeName(Employee employee) {
            employee.setName("李四");
        }

        public void reset(View view) {
            employee.setName("张三");
        }

        public void showDialog(View view) {
            Intent intent = new Intent(BindingTestActivity.this, ChangeDialogActivity.class);
            startActivity(intent);
        }
    }
}
