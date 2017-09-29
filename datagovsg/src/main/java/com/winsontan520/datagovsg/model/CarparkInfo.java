package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarparkInfo {

    @SerializedName("total_lots")
    @Expose
    private String totalLots;
    @SerializedName("lot_type")
    @Expose
    private String lotType;
    @SerializedName("lots_available")
    @Expose
    private String lotsAvailable;

    public String getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(String totalLots) {
        this.totalLots = totalLots;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getLotsAvailable() {
        return lotsAvailable;
    }

    public void setLotsAvailable(String lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }

    @Override
    public String toString() {
        return "CarparkInfo{" +
                "totalLots='" + totalLots + '\'' +
                ", lotType='" + lotType + '\'' +
                ", lotsAvailable='" + lotsAvailable + '\'' +
                '}';
    }
}
