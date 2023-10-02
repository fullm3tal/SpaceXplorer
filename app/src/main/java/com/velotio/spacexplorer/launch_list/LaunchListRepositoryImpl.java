package com.velotio.spacexplorer.launch_list;

import com.velotio.spacexplorer.ILaunchListResponse;
import com.velotio.spacexplorer.di.SpaceXService;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchListRepositoryImpl implements ILaunchListRepository {

    SpaceXService service;

    @Inject
    public LaunchListRepositoryImpl(SpaceXService spaceXService) {
        service = spaceXService;
    }

    @Override
    public void fetchLaunchListFromServer(ILaunchListResponse iLaunchListResponse){
        service.fetchLaunchList().enqueue(new Callback<ArrayList<LaunchInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<LaunchInfo>> call, Response<ArrayList<LaunchInfo>> response) {
                if (response.isSuccessful() && response.body()!=null ) {
                   iLaunchListResponse.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LaunchInfo>> call, Throwable t) {
               iLaunchListResponse.onFailure(t);
            }
        });

    }

}

