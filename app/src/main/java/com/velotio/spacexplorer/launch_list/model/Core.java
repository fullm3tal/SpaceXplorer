package com.velotio.spacexplorer.launch_list.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core implements Serializable
{

    @SerializedName("core_serial")
    @Expose
    private String coreSerial;
    @SerializedName("flight")
    @Expose
    private Integer flight;
    @SerializedName("block")
    @Expose
    private Object block;
    @SerializedName("gridfins")
    @Expose
    private Boolean gridfins;
    @SerializedName("legs")
    @Expose
    private Boolean legs;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("land_success")
    @Expose
    private Object landSuccess;
    @SerializedName("landing_intent")
    @Expose
    private Boolean landingIntent;
    @SerializedName("landing_type")
    @Expose
    private Object landingType;
    @SerializedName("landing_vehicle")
    @Expose
    private Object landingVehicle;
    private final static long serialVersionUID = 1155706521717737453L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Core() {
    }

    /**
     *
     * @param flight
     * @param landSuccess
     * @param landingType
     * @param gridfins
     * @param landingIntent
     * @param coreSerial
     * @param legs
     * @param landingVehicle
     * @param block
     * @param reused
     */
    public Core(String coreSerial, Integer flight, Object block, Boolean gridfins, Boolean legs, Boolean reused, Object landSuccess, Boolean landingIntent, Object landingType, Object landingVehicle) {
        super();
        this.coreSerial = coreSerial;
        this.flight = flight;
        this.block = block;
        this.gridfins = gridfins;
        this.legs = legs;
        this.reused = reused;
        this.landSuccess = landSuccess;
        this.landingIntent = landingIntent;
        this.landingType = landingType;
        this.landingVehicle = landingVehicle;
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Object getBlock() {
        return block;
    }

    public void setBlock(Object block) {
        this.block = block;
    }

    public Boolean getGridfins() {
        return gridfins;
    }

    public void setGridfins(Boolean gridfins) {
        this.gridfins = gridfins;
    }

    public Boolean getLegs() {
        return legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Object getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(Object landSuccess) {
        this.landSuccess = landSuccess;
    }

    public Boolean getLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(Boolean landingIntent) {
        this.landingIntent = landingIntent;
    }

    public Object getLandingType() {
        return landingType;
    }

    public void setLandingType(Object landingType) {
        this.landingType = landingType;
    }

    public Object getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(Object landingVehicle) {
        this.landingVehicle = landingVehicle;
    }

}