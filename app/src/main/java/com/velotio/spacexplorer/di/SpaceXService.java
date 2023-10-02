package com.velotio.spacexplorer.di;

import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceXService {

    @GET("/v3/launches")
    public Call<ArrayList<LaunchInfo>> fetchLaunchList();

}
