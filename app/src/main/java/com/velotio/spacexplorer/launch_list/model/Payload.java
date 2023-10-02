package com.velotio.spacexplorer.launch_list.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Payload implements Serializable
{
    @ColumnInfo(name = "payload_uid")
    @PrimaryKey
    public Long id;
    @SerializedName("payload_id")
    @Expose
    private String payloadId;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("payload_type")
    @Expose
    private String payloadType;
    @SerializedName("payload_mass_kg")
    @Expose
    private Double payloadMassKg;
    @SerializedName("payload_mass_lbs")
    @Expose
    private Double payloadMassLbs;
    @SerializedName("orbit")
    @Expose
    private String orbit;
    private final static long serialVersionUID = -8306574962610614685L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Payload() {
    }

    /**
     *
     * @param payloadId
     * @param payloadMassLbs
     * @param nationality
     * @param payloadType
     * @param payloadMassKg
     * @param reused
     * @param manufacturer
     */

    @Ignore
    public Payload(String payloadId, Boolean reused, String nationality, String manufacturer, String payloadType, Double payloadMassKg, Double payloadMassLbs) {
        super();
        this.payloadId = payloadId;
        this.reused = reused;
        this.nationality = nationality;
        this.manufacturer = manufacturer;
        this.payloadType = payloadType;
        this.payloadMassKg = payloadMassKg;
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Double getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Double payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public Double getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(Double payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

}