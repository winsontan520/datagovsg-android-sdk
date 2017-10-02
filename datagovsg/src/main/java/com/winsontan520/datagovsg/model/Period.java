package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Period {

    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("regions")
    @Expose
    private Regions regions;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Period{" +
                "time=" + time +
                ", regions=" + regions +
                '}';
    }
}
