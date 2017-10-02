
package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("update_timestamp")
    @Expose
    private String updateTimestamp;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("valid_period")
    @Expose
    private ValidPeriod validPeriod;
    @SerializedName("general")
    @Expose
    private General general;
    @SerializedName("periods")
    @Expose
    private List<Period> periods = null;
    @SerializedName("cameras")
    @Expose
    private List<Camera> cameras = null;
    @SerializedName("carpark_data")
    @Expose
    private List<CarparkData> carparkData = null;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = null;

    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ValidPeriod getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(ValidPeriod validPeriod) {
        this.validPeriod = validPeriod;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
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

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        return "Item{" +
                "updateTimestamp='" + updateTimestamp + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", validPeriod=" + validPeriod +
                ", general=" + general +
                ", periods=" + periods +
                ", cameras=" + cameras +
                ", carparkData=" + carparkData +
                ", forecasts=" + forecasts +
                '}';
    }
}
