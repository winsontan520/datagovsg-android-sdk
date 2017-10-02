package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelativeHumidity {

    @SerializedName("low")
    @Expose
    private Integer low;
    @SerializedName("high")
    @Expose
    private Integer high;

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "RelativeHumidity{" +
                "low=" + low +
                ", high=" + high +
                '}';
    }
}
