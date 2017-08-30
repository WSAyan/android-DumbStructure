package com.potato.wahidsadique.androiddumbstructure.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<Void> getTopRatedMovies(@Query("api_key") String authCode);

    @GET("movie/{id}")
    Call<Void> getMovieDetails(@Path("id") int id, @Query("api_key") String authCode);
}
