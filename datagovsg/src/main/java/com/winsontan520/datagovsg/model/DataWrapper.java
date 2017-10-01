
package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataWrapper {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("api_info")
    @Expose
    private ApiInfo apiInfo;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("crs")
    @Expose
    private Crs crs;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Crs getCrs() {
        return crs;
    }

    public void setCrs(Crs crs) {
        this.crs = crs;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "DataWrapper{" +
                "items=" + items +
                ", apiInfo=" + apiInfo +
                ", type='" + type + '\'' +
                ", crs=" + crs +
                ", features=" + features +
                '}';
    }
}
