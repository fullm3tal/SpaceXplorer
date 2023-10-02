package com.velotio.spacexplorer.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Upsert;

import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.List;

@Dao
public interface LaunchInfoDao {

    @Query("SELECT * FROM launchinfo")
    List<LaunchInfo> getAllLaunchDetails();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<LaunchInfo> list);

    @Query("DELETE FROM launchinfo where favorite=:value")
    void deleteAll(boolean value);

    @Upsert
    void updateLaunchInfo(LaunchInfo launchInfo);

}
