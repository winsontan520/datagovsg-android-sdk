package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaMeta {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("label_location")
    @Expose
    private LabelLocation labelLocation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LabelLocation getLabelLocation() {
        return labelLocation;
    }

    public void setLabelLocation(LabelLocation labelLocation) {
        this.labelLocation = labelLocation;
    }

    @Override
    public String toString() {
        return "AreaMeta{" +
                "name='" + name + '\'' +
                ", labelLocation=" + labelLocation +
                '}';
    }
}
