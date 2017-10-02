package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Regions {

    @SerializedName("west")
    @Expose
    private String west;
    @SerializedName("east")
    @Expose
    private String east;
    @SerializedName("central")
    @Expose
    private String central;
    @SerializedName("south")
    @Expose
    private String south;
    @SerializedName("north")
    @Expose
    private String north;

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "west='" + west + '\'' +
                ", east='" + east + '\'' +
                ", central='" + central + '\'' +
                ", south='" + south + '\'' +
                ", north='" + north + '\'' +
                '}';
    }
}
