package com.sohu.jetpacktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sohu.jetpacktest.room.AdsDatabase;
import com.sohu.jetpacktest.room.dao.DownloadDao;
import com.sohu.jetpacktest.room.entity.DownloadEntity;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private static final String TAG = "RoomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }

    public void onInsert(View view) {
        DownloadDao dao = AdsDatabase.getInstance().getDownloadDao();
        DownloadEntity downloadEntity = new DownloadEntity("http://www.baidu.com",
                1000000, 2900000, 3, 1, "test");
        Log.e(TAG, "Insert " + downloadEntity.toString());
        dao.insert(downloadEntity);
    }

    public void onQuery(View view) {
        DownloadDao dao = AdsDatabase.getInstance().getDownloadDao();
        List<DownloadEntity> list = dao.queryByStatus(new int[] { 3 });
        Log.e(TAG, list.toString());
    }

    public void onDelete(View view) {
        DownloadDao dao = AdsDatabase.getInstance().getDownloadDao();
        dao.deleteAll();
        Log.e(TAG, "Delete all download entities!");
    }
}
