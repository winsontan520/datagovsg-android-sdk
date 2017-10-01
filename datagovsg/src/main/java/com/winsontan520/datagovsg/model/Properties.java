package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("taxi_count")
    @Expose
    private Integer taxiCount;
    @SerializedName("api_info")
    @Expose
    private ApiInfo apiInfo;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTaxiCount() {
        return taxiCount;
    }

    public void setTaxiCount(Integer taxiCount) {
        this.taxiCount = taxiCount;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "href='" + href + '\'' +
                ", type='" + type + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", taxiCount=" + taxiCount +
                ", apiInfo=" + apiInfo +
                '}';
    }
}
