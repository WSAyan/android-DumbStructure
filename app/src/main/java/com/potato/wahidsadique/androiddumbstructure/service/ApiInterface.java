package com.potato.wahidsadique.androiddumbstructure.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public interface ApiInterface {
    @GET("v1/sources")
    Call<Void> getNewsSources(@Query("language") String language);
}
