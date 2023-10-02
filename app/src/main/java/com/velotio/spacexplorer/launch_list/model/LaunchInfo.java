package com.velotio.spacexplorer.launch_list.model;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.velotio.spacexplorer.R;

import java.io.Serializable;

@Entity
public class LaunchInfo implements Serializable {


    @PrimaryKey
    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
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

    @Embedded
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;

    @Embedded
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;

    @Embedded
    @SerializedName("launch_failure_details")
    @Expose
    private LaunchFailureDetails launchFailureDetails;

    public String detailLaunchStatus;

    @Embedded
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;

    private int colorId = R.color.blue;

    private final static long serialVersionUID = 7238764591150557943L;

    private boolean favorite = false;

    private String spaceLaunchStatus;

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

    public String getSpaceLaunchStatus() {
        return spaceLaunchStatus;
    }

    public void setSpaceLaunchStatus(String spaceLaunchStatus) {
        this.spaceLaunchStatus = spaceLaunchStatus;
    }

    /**
     * No args constructor for use in serialization
     */
    public LaunchInfo() {

    }

    /**
     * @param tentativeMaxPrecision
     * @param launchYear
     * @param isTentative
     * @param rocket
     * @param launchSite
     * @param launchFailureDetails
     * @param launchDateLocal
     * @param flightNumber
     * @param tbd
     * @param missionName
     * @param launchDateUtc
     * @param launchSuccess
     * @param links
     * @param details
     * @param launchDateUnix
     * @param launchWindow
     * @param upcoming
     */
    public LaunchInfo(Integer flightNumber, String missionName, Boolean upcoming, String launchYear, Integer launchDateUnix, String launchDateUtc, String launchDateLocal, Boolean isTentative, String tentativeMaxPrecision, Boolean tbd, Integer launchWindow, Rocket rocket,   LaunchSite launchSite, Boolean launchSuccess, LaunchFailureDetails launchFailureDetails, Links links, String details) {
        super();
        this.flightNumber = flightNumber;
        this.missionName = missionName;
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
        this.launchSite = launchSite;
        this.launchSuccess = launchSuccess;
        this.launchFailureDetails = launchFailureDetails;
        this.links = links;
        this.details = details;

    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getDetailLaunchStatus() {
        return detailLaunchStatus;
    }

    public void setDetailLaunchStatus(String detailLaunchStatus) {
        this.detailLaunchStatus = detailLaunchStatus;
    }


    /**
     *  Utility method to set Launch Status and color for statuses
     */
    public void updateSpaceLaunchStatus(){
        try {
            if (launchSuccess != null && launchSuccess) {
                setSpaceLaunchStatus("Success");
                setColorId(R.color.green);
                setDetailLaunchStatus("Success");
            } else if (upcoming != null && upcoming) {
                setSpaceLaunchStatus("Upcoming");
                setColorId(R.color.blue);
                setDetailLaunchStatus("Upcoming");
            } else {
                setSpaceLaunchStatus("Failure");
                if (launchFailureDetails != null && launchFailureDetails.getReason() != null) {
                    setDetailLaunchStatus(launchFailureDetails.getReason());
                } else {
                    setDetailLaunchStatus("Failure");
                }
                setColorId(R.color.red);
            }
        }catch (Exception e) {
            setColorId(R.color.blue);
        }
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

}