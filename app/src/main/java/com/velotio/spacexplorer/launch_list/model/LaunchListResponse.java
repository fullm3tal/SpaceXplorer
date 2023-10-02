package com.velotio.spacexplorer.launch_list.model;

import java.util.ArrayList;

public class LaunchListResponse {

    public ArrayList<LaunchInfo> list = new ArrayList<>();
    public boolean loading = true;
    public String error;

    public LaunchListResponse() {

    }

}
