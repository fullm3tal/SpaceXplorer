package com.velotio.spacexplorer.launch_list.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeline implements Serializable
{

    @SerializedName("webcast_liftoff")
    @Expose
    private Integer webcastLiftoff;
    private final static long serialVersionUID = 3895649080867056934L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Timeline() {
    }

    /**
     *
     * @param webcastLiftoff
     */
    public Timeline(Integer webcastLiftoff) {
        super();
        this.webcastLiftoff = webcastLiftoff;
    }

    public Integer getWebcastLiftoff() {
        return webcastLiftoff;
    }

    public void setWebcastLiftoff(Integer webcastLiftoff) {
        this.webcastLiftoff = webcastLiftoff;
    }

}