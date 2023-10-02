package com.velotio.spacexplorer.launch_list;

import com.velotio.spacexplorer.ILaunchListResponse;

import javax.annotation.Nullable;

public interface ILaunchListRepository {

  public void fetchLaunchListFromServer(@Nullable ILaunchListResponse iLaunchListResponse);

}
