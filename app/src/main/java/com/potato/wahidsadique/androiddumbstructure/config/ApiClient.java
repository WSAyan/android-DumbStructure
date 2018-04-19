package com.potato.wahidsadique.androiddumbstructure.config;

import com.potato.wahidsadique.androiddumbstructure.utility.GlobalConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class ApiClient {
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .client(getOkHttpClient())
                    .baseUrl(GlobalConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .connectTimeout(GlobalConstants.HTTP_TIMEOUT, TimeUnit.MINUTES)
                    .readTimeout(GlobalConstants.HTTP_TIMEOUT, TimeUnit.MINUTES)
                    .writeTimeout(GlobalConstants.HTTP_TIMEOUT, TimeUnit.MINUTES)
                    .build();
        }
        return okHttpClient;
    }
}
