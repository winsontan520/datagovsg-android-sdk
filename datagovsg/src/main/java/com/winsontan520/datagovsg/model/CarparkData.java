package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarparkData {

    @SerializedName("carpark_info")
    @Expose
    private List<CarparkInfo> carparkInfo = null;
    @SerializedName("carpark_number")
    @Expose
    private String carparkNumber;
    @SerializedName("update_datetime")
    @Expose
    private String updateDatetime;

    public List<CarparkInfo> getCarparkInfo() {
        return carparkInfo;
    }

    public void setCarparkInfo(List<CarparkInfo> carparkInfo) {
        this.carparkInfo = carparkInfo;
    }

    public String getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return "CarparkData{" +
                "carparkInfo=" + carparkInfo +
                ", carparkNumber='" + carparkNumber + '\'' +
                ", updateDatetime='" + updateDatetime + '\'' +
                '}';
    }
}
