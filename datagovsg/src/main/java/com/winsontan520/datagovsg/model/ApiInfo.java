
package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiInfo {

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override public String toString() {
        return "ApiInfo{" +
                "status='" + status + '\'' +
                '}';
    }
}
