package com.winsontan520.datagovsg;

import com.winsontan520.datagovsg.model.DataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Winson Tan on 4/9/17.
 */

public interface DataGovSgService {

    @GET("transport/traffic-images")
    Call<DataWrapper> getTrafficImages(@Query("date_time") String dateTime);

    @GET("transport/carpark-availability")
    Call<DataWrapper> getCarparkAvailability(@Query("date_time") String dateTime);

    @GET("transport/taxi-availability")
    Call<DataWrapper> getTaxiAvailability(@Query("date_time") String dateTime);

}
