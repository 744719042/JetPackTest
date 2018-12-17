package com.sohu.jetpacktest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.sohu.jetpacktest.room.AdsDatabase;
import com.sohu.jetpacktest.room.entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DatabaseWorker extends Worker {
    private static final String TAG = "DatabaseWorker";
    public DatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        List<MovieEntity> data = new ArrayList<MovieEntity>() {
            {
                add(new MovieEntity(R.drawable.rmdmy, "人民的名义", "中央军委后勤保障部金盾影视中心出品的检察反腐电视剧"));
                add(new MovieEntity(R.drawable.qm, "法医秦明案", "法医秦明与法医助理大宝、刑警队大队长林涛屡破要案的故事"));
                add(new MovieEntity(R.drawable.bigbang, "生活大爆炸", "讲述的是四个宅男科学家和一个美女邻居发生的搞笑生活故事"));
            }
        };

        Log.e(TAG, "Insert movies");
        for (int i = 0; i < 200; i++) {
            MovieEntity entity = data.get(i % 3);
            entity.setName(entity.getName().substring(0, 5) + i);
            AdsDatabase.getInstance().getMovieDao().save(entity);
        }
        return Result.success();
    }
}
