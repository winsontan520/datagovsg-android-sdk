
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

    @Override public String toString() {
        return "Item{" +
                "timestamp='" + timestamp + '\'' +
                ", cameras=" + cameras +
                '}';
    }
}
