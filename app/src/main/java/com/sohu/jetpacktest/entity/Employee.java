package com.sohu.jetpacktest.entity;

public class Employee {
    private int portrait;
    private String name;
    private String phone;
    private int sex;
    private String address;
    private String email;

    public Employee(int portrait, String name, String phone, int sex, String address, String email) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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
