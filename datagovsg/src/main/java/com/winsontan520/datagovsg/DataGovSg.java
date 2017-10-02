package com.winsontan520.datagovsg;

import com.winsontan520.datagovsg.model.DataWrapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Winson Tan on 4/12/17.
 */

public class DataGovSg {

    private static DataGovSg singleton;

    private Map<String, String> headers;
    private DataGovSgService services;
    private static String DEFAULT_BASE_URL = "https://api.data.gov.sg/v1/";
    private String baseUrl;

    private DataGovSg(String apiKey, String baseUrl) {
        this.headers = new HashMap<>();
        this.baseUrl = baseUrl;

        // default header apiKey required by DataGovSg
        headers.put("api-key", apiKey);

        initNetworkComponent();
    }

    public static void initialize(String apiKey) {
        if (singleton == null) {
            singleton = new DataGovSg(apiKey, DEFAULT_BASE_URL);
        }
    }

    // use this if one day the base url changed
    public static void initialize(String apiKey, String baseUrl) {
        if (singleton == null) {
            singleton = new DataGovSg(apiKey, baseUrl);
        }
    }

    private void initNetworkComponent() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();

                // add custom headers
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    requestBuilder.header(entry.getKey(), entry.getValue());
                }

                requestBuilder.method(original.method(), original.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        services = retrofit.create(DataGovSgService.class);
    }

    private DataGovSgService getServices() {
        return services;
    }

    public static void requestTrafficImages(final Callback<DataWrapper> callback) {
        requestTrafficImages(callback, null);
    }

    public static void requestTrafficImages(final Callback<DataWrapper> callback, String dateTime) {
        singleton.getServices().getTrafficImages(dateTime).enqueue(callback);
    }

    public static void requestCarparkAvailability(final Callback<DataWrapper> callback) {
        requestCarparkAvailability(callback, null);
    }

    public static void requestCarparkAvailability(final Callback<DataWrapper> callback, String dateTime) {
        singleton.getServices().getCarparkAvailability(dateTime).enqueue(callback);
    }

    public static void requestTaxiAvailability(final Callback<DataWrapper> callback) {
        requestTaxiAvailability(callback, null);
    }

    public static void requestTaxiAvailability(final Callback<DataWrapper> callback, String dateTime) {
        singleton.getServices().getTaxiAvailability(dateTime).enqueue(callback);
    }

    public static void request2HourForecast(final Callback<DataWrapper> callback) {
        request2HourForecast(callback, null, null);
    }

    public static void request2HourForecast(final Callback<DataWrapper> callback, String dateTime, String date) {
        singleton.getServices().get2HourWeatherForecast(dateTime, date).enqueue(callback);
    }

    public static void request24HourForecast(final Callback<DataWrapper> callback) {
        request24HourForecast(callback, null, null);
    }

    public static void request24HourForecast(final Callback<DataWrapper> callback, String dateTime, String date) {
        singleton.getServices().get24HourWeatherForecast(dateTime, date).enqueue(callback);
    }
}
