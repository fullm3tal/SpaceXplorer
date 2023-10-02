package com.velotio.spacexplorer.launch_list.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Rocket implements Serializable
{

    @ColumnInfo(name = "rocket_uid")
    @PrimaryKey
    public Long id;
    @SerializedName("rocket_id")
    @Expose
    private String rocketId;
    @SerializedName("rocket_name")
    @Expose
    private String rocketName;
    @SerializedName("rocket_type")
    @Expose
    private String rocketType;
    @Embedded
    @SerializedName("fairings")
    @Expose
    private Fairings fairings;
    private final static long serialVersionUID = 6194551240326071552L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rocket() {
    }

    /**
     *
     * @param rocketId
     * @param fairings
     * @param rocketType
     * @param rocketName
     */

    @Ignore
    public Rocket(String rocketId, String rocketName, String rocketType, Fairings fairings) {
        super();
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;

        this.fairings = fairings;
    }

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    public Fairings getFairings() {
        return fairings;
    }

    public void setFairings(Fairings fairings) {
        this.fairings = fairings;
    }

}