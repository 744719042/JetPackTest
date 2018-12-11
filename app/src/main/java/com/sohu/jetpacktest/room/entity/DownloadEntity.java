package com.sohu.jetpacktest.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "tb_download")
public class DownloadEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;
    private long startTime;
    private long downloadTime;
    private int status;
    private int loadType;
    private String description;

    public DownloadEntity(String url, long startTime, long downloadTime, int status, int loadType, String description) {
        this.url = url;
        this.startTime = startTime;
        this.downloadTime = downloadTime;
        this.status = status;
        this.loadType = loadType;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(long downloadTime) {
        this.downloadTime = downloadTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLoadType() {
        return loadType;
    }

    public void setLoadType(int loadType) {
        this.loadType = loadType;
    }

    public String getDescription() {
        return description;
    }

    public void setDscription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownloadEntity that = (DownloadEntity) o;
        return id == that.id &&
                startTime == that.startTime &&
                downloadTime == that.downloadTime &&
                status == that.status &&
                loadType == that.loadType &&
                Objects.equals(url, that.url) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, startTime, downloadTime, status, loadType, description);
    }

    @Override
    public String toString() {
        return "DownloadEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", startTime=" + startTime +
                ", downloadTime=" + downloadTime +
                ", status=" + status +
                ", loadType=" + loadType +
                ", description='" + description + '\'' +
                '}';
    }
}
