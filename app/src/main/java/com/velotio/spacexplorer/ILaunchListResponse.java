package com.velotio.spacexplorer;

import com.velotio.spacexplorer.launch_list.model.LaunchInfo;

import java.util.ArrayList;

public interface ILaunchListResponse {

    public void onResponse(ArrayList<LaunchInfo> response);

    public void onFailure(Throwable t);

}
