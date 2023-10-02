package com.velotio.spacexplorer.launch_list;


import androidx.lifecycle.MutableLiveData;

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

    //TODO remove thread
    Thread outerThread;

    MutableLiveData<LaunchListResponse> listMutableLiveData = new MutableLiveData<>(new LaunchListResponse());
    SpaceXService service;

    LaunchInfoDao dao;

    @Inject
    public LaunchListRepositoryImpl(SpaceXService spaceXService, LaunchInfoDao dao) {
        this.dao = dao;
        service = spaceXService;
    }

    @Override
    public MutableLiveData<LaunchListResponse> fetchLaunchListFromServer() {
        try {
            listMutableLiveData.postValue(new LaunchListResponse());
            AppDatabase.databaseWriteExecutor.execute(() -> {
                ArrayList<LaunchInfo> list = (ArrayList<LaunchInfo>) dao.getAllLaunchDetails();
                System.out.println("Outer Thread " + Thread.currentThread().getName());
                if (!list.isEmpty()) {
                    LaunchListResponse response = new LaunchListResponse();
                    response.loading = false;
                    response.list = list;
                    listMutableLiveData.postValue(response);
                }
                outerThread = Thread.currentThread();
                service.fetchLaunchList().enqueue(new Callback<ArrayList<LaunchInfo>>() {
                    @Override
                    public void onResponse(Call<ArrayList<LaunchInfo>> call, Response<ArrayList<LaunchInfo>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            System.out.println("Middle Thread " + Thread.currentThread().getName());
                            AppDatabase.databaseWriteExecutor.execute(() -> {
                                System.out.println("Inner Thread " + Thread.currentThread().getName());
                                System.out.println("Is Outer thread alive " + outerThread.isAlive());
                                dao.deleteAll(false);
                                dao.insertAll(response.body());
                                ArrayList<LaunchInfo> list = (ArrayList<LaunchInfo>) dao.getAllLaunchDetails();
                                if (!list.isEmpty()) {
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

    @Override
    public void updateLaunchInfo(LaunchInfo launchInfo) {
        AppDatabase.databaseWriteExecutor.execute(() -> dao.updateLaunchInfo(launchInfo));
    }

}

