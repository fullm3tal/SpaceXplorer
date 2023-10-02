package com.velotio.spacexplorer.launch_list.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
public class LaunchFailureDetails implements Serializable
{
    @ColumnInfo(name = "launch_failure_details_uid")
    @PrimaryKey
    public Long id;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("altitude")
    @Expose
    private Integer altitude;
    @SerializedName("reason")
    @Expose
    private String reason;
    private final static long serialVersionUID = 621808750342093780L;

    /**
     * No args constructor for use in serialization
     *
     */
    public LaunchFailureDetails() {
    }

    /**
     *
     * @param altitude
     * @param reason
     * @param time
     */
    @Ignore
    public LaunchFailureDetails(Integer time, Integer altitude, String reason) {
        super();
        this.time = time;
        this.altitude = altitude;
        this.reason = reason;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}