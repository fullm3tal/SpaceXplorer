package com.velotio.spacexplorer.launch_list.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class LaunchSite implements Serializable
{
    @ColumnInfo(name = "launch_site_uid")
    @PrimaryKey
    public Long id;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("site_name")
    @Expose
    private String siteName;
    @SerializedName("site_name_long")
    @Expose
    private String siteNameLong;
    private final static long serialVersionUID = -6309295352089762351L;

    /**
     * No args constructor for use in serialization
     *
     */
    public LaunchSite() {
    }

    /**
     *
     * @param siteNameLong
     * @param siteId
     * @param siteName
     */
    @Ignore
    public LaunchSite(String siteId, String siteName, String siteNameLong) {
        super();
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteNameLong = siteNameLong;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

}
