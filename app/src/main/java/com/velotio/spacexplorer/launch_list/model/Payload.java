package com.velotio.spacexplorer.launch_list.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload implements Serializable
{

    @SerializedName("payload_id")
    @Expose
    private String payloadId;
    @SerializedName("norad_id")
    @Expose
    private List<Object> noradId;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("customers")
    @Expose
    private List<String> customers;
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
    private Object payloadMassKg;
    @SerializedName("payload_mass_lbs")
    @Expose
    private Object payloadMassLbs;
    @SerializedName("orbit")
    @Expose
    private String orbit;
    @SerializedName("orbit_params")
    @Expose
    private OrbitParams orbitParams;
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
     * @param noradId
     * @param nationality
     * @param payloadType
     * @param payloadMassKg
     * @param customers
     * @param orbit
     * @param reused
     * @param orbitParams
     * @param manufacturer
     */
    public Payload(String payloadId, List<Object> noradId, Boolean reused, List<String> customers, String nationality, String manufacturer, String payloadType, Object payloadMassKg, Object payloadMassLbs, String orbit, OrbitParams orbitParams) {
        super();
        this.payloadId = payloadId;
        this.noradId = noradId;
        this.reused = reused;
        this.customers = customers;
        this.nationality = nationality;
        this.manufacturer = manufacturer;
        this.payloadType = payloadType;
        this.payloadMassKg = payloadMassKg;
        this.payloadMassLbs = payloadMassLbs;
        this.orbit = orbit;
        this.orbitParams = orbitParams;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<Object> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<Object> noradId) {
        this.noradId = noradId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
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

    public Object getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Object payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public Object getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(Object payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }

}