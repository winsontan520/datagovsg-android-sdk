package com.winsontan520.datagovsg;

import com.winsontan520.datagovsg.model.DataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Winson Tan on 4/9/17.
 */

public interface DataGovSgService {

    @GET("transport/traffic-images")
    Call<DataWrapper> getTrafficImages();
}
