package com.velotio.spacexplorer.launch_list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class FirstStage implements Serializable
{

    @SerializedName("cores")
    @Expose
    private List<Core> cores;
    private final static long serialVersionUID = 3268555405126712710L;

    /**
     * No args constructor for use in serialization
     *
     */
    public FirstStage() {
    }

    /**
     *
     * @param cores
     */
    public FirstStage(List<Core> cores) {
        super();
        this.cores = cores;
    }

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

}
