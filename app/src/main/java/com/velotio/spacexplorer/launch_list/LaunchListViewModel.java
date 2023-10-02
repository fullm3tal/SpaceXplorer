package com.velotio.spacexplorer.launch_list;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.velotio.spacexplorer.launch_list.model.LaunchInfo;
import com.velotio.spacexplorer.launch_list.model.LaunchListResponse;
import com.velotio.spacexplorer.utils.CountdownTimer;

import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LaunchListViewModel extends ViewModel {
    ILaunchListRepository repository;
    LiveData<LaunchListResponse> launchListResponseLiveData;
    private final MutableLiveData<Integer> favoriteMutableLiveData = new MutableLiveData<>(null);
    LiveData<Integer> favoriteLiveData = favoriteMutableLiveData;

    CountdownTimer timer = new CountdownTimer();

    public CountdownTimer getTimer() {
        return timer;
    }

    public void setTimer(CountdownTimer timer) {
        this.timer = timer;
    }

    private final MutableLiveData<Boolean> navigateMutableLiveData = new MutableLiveData<>(false);
    LiveData<Boolean> navigateLiveData = navigateMutableLiveData;
    LaunchInfo launchInfo;

    public LaunchInfo getLaunchInfo() {
        return launchInfo;
    }

    public void setLaunchInfo(LaunchInfo launchInfo) {
        this.launchInfo = launchInfo;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Inject
    public LaunchListViewModel(ILaunchListRepository iLaunchListRepository) {
        repository = iLaunchListRepository;
        setLaunchList();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setLaunchList() {
        launchListResponseLiveData = repository.fetchLaunchListFromServer();
    }

    public LiveData<LaunchListResponse> getSpaceLaunchInfo() {
        return launchListResponseLiveData;
    }

    /**
     *
     * @param isFavorite true or false
     * @param position item's position in list
     */
    public void setLaunchFavorite(boolean isFavorite, int position) {
        try {
            LaunchInfo launchInfo = Objects.requireNonNull(launchListResponseLiveData.getValue()).list.get(position);
            launchInfo.setFavorite(isFavorite);
            favoriteMutableLiveData.setValue(position);
            repository.updateLaunchInfo(launchInfo);
        } finally {
            favoriteMutableLiveData.setValue(null);
        }
    }

    public void navigateToLaunchDetail(LaunchInfo spaceLaunchInfo) {
        try {
            launchInfo = spaceLaunchInfo;
            navigateMutableLiveData.setValue(true);
        } finally {
            navigateMutableLiveData.setValue(false);
        }
    }
}