package com.velotio.spacexplorer.launch_list.model;


import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.velotio.spacexplorer.R;

public class LaunchInfo implements Serializable {

    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("mission_id")
    @Expose
    private List<Object> missionId;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("is_tentative")
    @Expose
    private Boolean isTentative;
    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @SerializedName("tbd")
    @Expose
    private Boolean tbd;
    @SerializedName("launch_window")
    @Expose
    private Integer launchWindow;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("ships")
    @Expose
    private List<Object> ships;
    @SerializedName("telemetry")
    @Expose
    private Telemetry telemetry;
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;
    @SerializedName("launch_failure_details")
    @Expose
    private LaunchFailureDetails launchFailureDetails;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("static_fire_date_utc")
    @Expose
    private Object staticFireDateUtc;
    @SerializedName("static_fire_date_unix")
    @Expose
    private Object staticFireDateUnix;
    @SerializedName("timeline")
    @Expose
    private Timeline timeline;
    @SerializedName("crew")
    @Expose
    private Object crew;

    private final static long serialVersionUID = 7238764591150557943L;

    private boolean favorite = false;

    private Integer launchFavorite = R.drawable.star_outline;

    public Integer getLaunchFavorite() {
        return launchFavorite;
    }

    public void setLaunchFavorite(Integer launchFavorite) {
        this.launchFavorite = launchFavorite;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * No args constructor for use in serialization
     */
    public LaunchInfo() {
    }

    /**
     * @param tentativeMaxPrecision
     * @param staticFireDateUtc
     * @param missionId
     * @param launchYear
     * @param isTentative
     * @param rocket
     * @param launchSite
     * @param launchFailureDetails
     * @param launchDateLocal
     * @param flightNumber
     * @param crew
     * @param ships
     * @param tbd
     * @param missionName
     * @param launchDateUtc
     * @param launchSuccess
     * @param timeline
     * @param telemetry
     * @param links
     * @param details
     * @param staticFireDateUnix
     * @param launchDateUnix
     * @param launchWindow
     * @param upcoming
     */
    public LaunchInfo(Integer flightNumber, String missionName, List<Object> missionId, Boolean upcoming, String launchYear, Integer launchDateUnix, String launchDateUtc, String launchDateLocal, Boolean isTentative, String tentativeMaxPrecision, Boolean tbd, Integer launchWindow, Rocket rocket, List<Object> ships, Telemetry telemetry, LaunchSite launchSite, Boolean launchSuccess, LaunchFailureDetails launchFailureDetails, Links links, String details, Object staticFireDateUtc, Object staticFireDateUnix, Timeline timeline, Object crew) {
        super();
        this.flightNumber = flightNumber;
        this.missionName = missionName;
        this.missionId = missionId;
        this.upcoming = upcoming;
        this.launchYear = launchYear;
        this.launchDateUnix = launchDateUnix;
        this.launchDateUtc = launchDateUtc;
        this.launchDateLocal = launchDateLocal;
        this.isTentative = isTentative;
        this.tentativeMaxPrecision = tentativeMaxPrecision;
        this.tbd = tbd;
        this.launchWindow = launchWindow;
        this.rocket = rocket;
        this.ships = ships;
        this.telemetry = telemetry;
        this.launchSite = launchSite;
        this.launchSuccess = launchSuccess;
        this.launchFailureDetails = launchFailureDetails;
        this.links = links;
        this.details = details;
        this.staticFireDateUtc = staticFireDateUtc;
        this.staticFireDateUnix = staticFireDateUnix;
        this.timeline = timeline;
        this.crew = crew;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<Object> getMissionId() {
        return missionId;
    }

    public void setMissionId(List<Object> missionId) {
        this.missionId = missionId;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public void setTbd(Boolean tbd) {
        this.tbd = tbd;
    }

    public Integer getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(Integer launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<Object> getShips() {
        return ships;
    }

    public void setShips(List<Object> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
        this.launchFailureDetails = launchFailureDetails;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(Object staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public Object getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(Object staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Object getCrew() {
        return crew;
    }

    public void setCrew(Object crew) {
        this.crew = crew;
    }

}