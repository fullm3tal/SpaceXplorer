package com.velotio.spacexplorer.di;

import android.content.Context;

import androidx.room.Room;


import com.velotio.spacexplorer.db.AppDatabase;
import com.velotio.spacexplorer.db.LaunchInfoDao;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class PersistenceModule {

    @Provides
    public AppDatabase providesDatabase(@ApplicationContext  Context context) {
        return Room.databaseBuilder(
                context, AppDatabase.class, "db"
                ).build();
    }

    @Provides
    public LaunchInfoDao providesLaunchInfoDao(AppDatabase database) {
        return  database.launchInfoDao();
    }

}
