package com.velotio.spacexplorer.launch_list;

import androidx.lifecycle.MutableLiveData;

import com.velotio.spacexplorer.launch_list.model.LaunchInfo;
import com.velotio.spacexplorer.launch_list.model.LaunchListResponse;

public interface ILaunchListRepository {

  public MutableLiveData<LaunchListResponse> fetchLaunchListFromServer();

  void updateLaunchInfo(LaunchInfo launchInfo);
}
