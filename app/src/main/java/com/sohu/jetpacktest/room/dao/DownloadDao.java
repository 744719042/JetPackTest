package com.sohu.jetpacktest.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sohu.jetpacktest.room.entity.DownloadEntity;

import java.util.List;

@Dao
public interface DownloadDao {
    @Insert
    void insert(DownloadEntity entity);

    @Query("delete from tb_download")
    void deleteAll();

    @Query("select * from tb_download where status in (:status)")
    List<DownloadEntity> queryByStatus(int[] status);
}
