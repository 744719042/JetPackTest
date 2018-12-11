package com.sohu.jetpacktest.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import com.sohu.jetpacktest.BR;
import com.sohu.jetpacktest.app.JetPackApplication;

public class Employee extends BaseObservable {
    private int portrait;
    private String name;
    private String phone;
    private boolean sex;
    private String address;
    private String email;

    public Employee(int portrait, String name, String phone, boolean sex, String address, String email) {
        this.portrait = portrait;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
        this.email = email;
    }

    public int getPortrait() {
        return portrait;
    }

    public void setPortrait(int portrait) {
        this.portrait = portrait;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        if (sex != this.sex) {
            this.sex = sex;
            Toast.makeText(JetPackApplication.sContext, "sex = " + sex, Toast.LENGTH_SHORT).show();
            notifyPropertyChanged(BR.sex);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
