package com.velotio.spacexplorer.launch_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.velotio.spacexplorer.launch_list.model.LaunchInfo;
import com.velotio.spacexplorer.launch_list.model.LaunchListResponse;
import java.util.Objects;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LaunchListViewModel extends ViewModel {

    ILaunchListRepository repository;

    LiveData<LaunchListResponse> launchListResponseLiveData;

    private final MutableLiveData<Integer> favoriteMutableLiveData = new MutableLiveData<>(null);
    LiveData<Integer> favoriteLiveData = favoriteMutableLiveData;

    @Inject
    public LaunchListViewModel(ILaunchListRepository iLaunchListRepository) {
        repository = iLaunchListRepository;
        setLaunchList();
    }

    public void setLaunchList(){
        launchListResponseLiveData = repository.fetchLaunchListFromServer();
    }

    public LiveData<LaunchListResponse> getLaunchInfo() {
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
}