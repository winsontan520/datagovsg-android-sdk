package com.winsontan520.datagovsg.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class General {

    @SerializedName("forecast")
    @Expose
    private String forecast;
    @SerializedName("relative_humidity")
    @Expose
    private RelativeHumidity relativeHumidity;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("wind")
    @Expose
    private Wind wind;

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public RelativeHumidity getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(RelativeHumidity relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "General{" +
                "forecast='" + forecast + '\'' +
                ", relativeHumidity=" + relativeHumidity +
                ", temperature=" + temperature +
                ", wind=" + wind +
                '}';
    }
}
