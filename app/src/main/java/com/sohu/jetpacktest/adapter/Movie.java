package com.sohu.jetpacktest.adapter;

public class Movie {
    private int portrait;
    private String name;
    private String description;

    public Movie(int portrait, String name, String description) {
        this.portrait = portrait;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
