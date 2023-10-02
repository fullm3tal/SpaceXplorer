package com.velotio.spacexplorer.launch_list;


import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.velotio.spacexplorer.utils.Utils;
import com.velotio.spacexplorer.db.AppDatabase;
import com.velotio.spacexplorer.db.LaunchInfoDao;
import com.velotio.spacexplorer.service.SpaceXService;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;
import com.velotio.spacexplorer.launch_list.model.LaunchListResponse;

import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchListRepositoryImpl implements ILaunchListRepository {

    MutableLiveData<LaunchListResponse> listMutableLiveData = new MutableLiveData<>(new LaunchListResponse());
    SpaceXService service;
    LaunchInfoDao dao;

    @Inject
    public LaunchListRepositoryImpl(SpaceXService spaceXService, LaunchInfoDao dao) {
        this.dao = dao;
        service = spaceXService;
    }

    /**
     *  Fetches data from the local storage first and then from the server.
     * @return MutableLiveData<LaunchListResponse>
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public MutableLiveData<LaunchListResponse> fetchLaunchListFromServer() {
        try {
            listMutableLiveData.postValue(new LaunchListResponse());
            AppDatabase.databaseWriteExecutor.execute(() -> {
                ArrayList<LaunchInfo> list = (ArrayList<LaunchInfo>) dao.getAllLaunchDetails();
                System.out.println("Outer Thread " + Thread.currentThread().getName());
                if (!list.isEmpty()) {
                    fetchLocalDateTime(list);
                    LaunchListResponse response = new LaunchListResponse();
                    response.loading = false;
                    response.list = list;
                    listMutableLiveData.postValue(response);
                }
                service.fetchLaunchList().enqueue(new Callback<ArrayList<LaunchInfo>>() {
                    @Override
                    public void onResponse(Call<ArrayList<LaunchInfo>> call, Response<ArrayList<LaunchInfo>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            AppDatabase.databaseWriteExecutor.execute(() -> {
                                dao.deleteAll(false);
                                dao.insertAll(response.body());
                                ArrayList<LaunchInfo> list = (ArrayList<LaunchInfo>) dao.getAllLaunchDetails();
                                if (!list.isEmpty()) {
                                    fetchLocalDateTime(list);
                                    LaunchListResponse launchListResponse = new LaunchListResponse();
                                    launchListResponse.loading = false;
                                    launchListResponse.list = list;
                                    listMutableLiveData.postValue(launchListResponse);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<LaunchInfo>> call, Throwable t) {
                        if (Objects.requireNonNull(listMutableLiveData.getValue()).list.isEmpty()) {
                            LaunchListResponse launchListResponse = new LaunchListResponse();
                            launchListResponse.loading = false;
                            launchListResponse.error = "Something went wrong";
                            listMutableLiveData.postValue(launchListResponse);
                        }
                    }
                });
            });
        } catch (Exception e) {
            LaunchListResponse launchListResponse = new LaunchListResponse();
            launchListResponse.loading = false;
            launchListResponse.error = "Something went wrong";
            listMutableLiveData.postValue(launchListResponse);
        }
        return listMutableLiveData;
    }


    /**
     *  Method to update launch info
     * @param launchInfo
     */
    @Override
    public void updateLaunchInfo(LaunchInfo launchInfo) {
        AppDatabase.databaseWriteExecutor.execute(() -> dao.updateLaunchInfo(launchInfo));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void fetchLocalDateTime(ArrayList<LaunchInfo> list) {
        ArrayList<LaunchInfo> data = list;
       list.forEach(launchInfo -> {
            launchInfo.setLaunchDateLocal(Utils.getLocalDateTime(launchInfo.getLaunchDateLocal()));
        });
    }

}

