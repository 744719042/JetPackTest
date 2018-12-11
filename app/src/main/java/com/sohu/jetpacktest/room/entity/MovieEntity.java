package com.sohu.jetpacktest.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Objects;

@Entity(tableName = "tb_movie")
public class MovieEntity {
    private int portrait;
    @PrimaryKey
    @NonNull
    private String name;
    private String description;

    public MovieEntity(int portrait, String name, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity movieEntity = (MovieEntity) o;
        return portrait == movieEntity.portrait &&
                Objects.equals(name, movieEntity.name) &&
                Objects.equals(description, movieEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portrait, name, description);
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "portrait=" + portrait +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
