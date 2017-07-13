package com.winsontan520.datagovsg;

import com.winsontan520.datagovsg.model.DataWrapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
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

    private DataGovSg(String apiKey) {
        this.headers = new HashMap<>();

        // default header apiKey required by DataGovSg
        headers.put("api-key", apiKey);

        initNetworkComponent();
    }

    public static void initialize(String apiKey) {
        if (singleton == null) {
            singleton = new DataGovSg(apiKey);
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
                .baseUrl("https://api.data.gov.sg/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        services = retrofit.create(DataGovSgService.class);
    }

    private DataGovSgService getServices() {
        return services;
    }

    public static void requestTrafficImages(final Callback<DataWrapper> callback) {
        Call<DataWrapper> call = singleton.getServices().getTrafficImages();
//        call.enqueue(new Callback<DataWrapper>() {
//
//            @Override
//            public void onResponse(Call<DataWrapper> call, Response<DataWrapper> response) {
//                callback.onResponse(response);
//            }
//
//            @Override
//            public void onFailure(Call<DataWrapper> call, Throwable t) {
//                callback.onFailure(t);
//            }
//        });
        call.enqueue(callback);
    }
}
