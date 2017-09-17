package com.potato.wahidsadique.androiddumbstructure.service;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.model.config.ApiClient;
import com.potato.wahidsadique.androiddumbstructure.model.config.DbConfig;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Source;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Sources;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wahid.sadique on 9/11/2017.
 */

public class HttpService implements IHttpService {
    private DbCrud dbCrud;
    private DbConfig dbConfig;
    private ApiInterface apiService;
    private List<Source> sources;

    public HttpService(DbCrud dbCrud, DbConfig dbConfig) {
        this.dbCrud = dbCrud;
        this.dbConfig = dbConfig;
        this.apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public List<Source> getSourceList() {
        String language = "en";
        Call<Sources> call = apiService.getNewsSources(language);
        sources = new ArrayList<>();
        call.enqueue(new Callback<Sources>() {
            @Override
            public void onResponse(Call<Sources> call, Response<Sources> response) {
                sources = response.body().getSources();
            }

            @Override
            public void onFailure(Call<Sources> call, Throwable t) {
            }
        });
        return sources;
    }
}
