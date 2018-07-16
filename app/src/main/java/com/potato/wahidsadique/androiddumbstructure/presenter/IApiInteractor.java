package com.potato.wahidsadique.androiddumbstructure.presenter;

import com.potato.wahidsadique.androiddumbstructure.model.pojo.Sources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public interface IApiInteractor {
    @GET("v2/sources")
    Call<Sources> getNewsSources(@Header("X-Api-Key") String apiKey, @Query("language") String language);
}
