package com.winsontan520.datagovsg;

import com.winsontan520.datagovsg.model.DataWrapper;

import retrofit2.Response;

/**
 * Created by Winson Tan on 4/12/17.
 */

public interface DataGovSgCallback {
    void onResponse(Response<DataWrapper> responseWrapper);
    void onFailure(Throwable t);
}
