package com.sohu.jetpacktest.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.sohu.jetpacktest.room.dao.DownloadDao;
import com.sohu.jetpacktest.room.entity.DownloadEntity;

@Database(entities = { DownloadEntity.class }, version = 2)
public abstract class AdsDatabase extends RoomDatabase {
    private static AdsDatabase INSTANCE;
    private static Context sContext;

    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    public static AdsDatabase getInstance() {
        if (INSTANCE == null) {
            synchronized (AdsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(sContext, AdsDatabase.class, "ads_database.db")
                            .addCallback(new Callback() {
                                    @Override
                                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                        super.onCreate(db);
                                    }

                                    @Override
                                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                        super.onOpen(db);
                                    }
                                })
                            .addMigrations(new Migration(1, 2) {
                                @Override
                                public void migrate(@NonNull SupportSQLiteDatabase database) {
                                    database.execSQL("alter table tb_download add column description varchar(255);");
                                }
                            })
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DownloadDao getDownloadDao();
}
