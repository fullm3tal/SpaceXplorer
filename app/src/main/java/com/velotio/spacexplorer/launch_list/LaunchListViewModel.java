package com.velotio.spacexplorer.launch_list;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.velotio.spacexplorer.ILaunchListResponse;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LaunchListViewModel extends ViewModel {

    ILaunchListRepository repository;

    MutableLiveData<ArrayList<LaunchInfo>> listMutableLiveData = new MutableLiveData<>();
    LiveData<ArrayList<LaunchInfo>> listLiveData = listMutableLiveData;

    MutableLiveData<Boolean> favoriteMutableLiveData = new MutableLiveData<>(false);
    LiveData<Boolean> favoriteLiveData = favoriteMutableLiveData;

    @Inject
    public LaunchListViewModel(ILaunchListRepository iLaunchListRepository) {
        repository = iLaunchListRepository;
    }

    public void fetchLaunchInfoFromServer() {
        repository.fetchLaunchListFromServer(new ILaunchListResponse() {
            @Override
            public void onResponse(@Nullable ArrayList<LaunchInfo> response) {
                assert response != null;
                Log.e("TAG", "response.size=" + response.size());
                listMutableLiveData.setValue(response);
            }

            @Override
            public void onFailure(@Nullable Throwable t) {
                Log.e("TAG", "Failure" + t);
                listMutableLiveData.setValue(new ArrayList<>());
            }
        });
    }

    public void setLaunchFavorite(boolean isFavorite, int position) {
        try {
            LaunchInfo launchInfo = listMutableLiveData.getValue().get(position);
            launchInfo.setFavorite(isFavorite);
            favoriteMutableLiveData.setValue(true);
        } finally {
            favoriteMutableLiveData.setValue(false);
        }

    }
}