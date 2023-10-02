package com.velotio.spacexplorer.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.velotio.spacexplorer.db.LaunchInfoDao;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LaunchInfo.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract LaunchInfoDao launchInfoDao();

}
