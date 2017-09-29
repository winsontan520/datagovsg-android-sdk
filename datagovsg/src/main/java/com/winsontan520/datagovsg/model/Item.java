
package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("cameras")
    @Expose
    private List<Camera> cameras = null;
    @SerializedName("carpark_data")
    @Expose
    private List<CarparkData> carparkData = null;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public List<CarparkData> getCarparkData() {
        return carparkData;
    }

    public void setCarparkData(List<CarparkData> carparkData) {
        this.carparkData = carparkData;
    }

    @Override public String toString() {
        return "Item{" +
                "timestamp='" + timestamp + '\'' +
                ", cameras=" + cameras +
                '}';
    }
}
