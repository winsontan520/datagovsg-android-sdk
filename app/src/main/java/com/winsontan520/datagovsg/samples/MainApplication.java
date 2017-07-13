package com.winsontan520.datagovsg.samples;

import android.app.Application;

import com.winsontan520.datagovsg.DataGovSg;

/**
 * Created by Winson Tan on 4/12/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DataGovSg.initialize(BuildConfig.API_KEY); // replace with your own API key
    }
}
