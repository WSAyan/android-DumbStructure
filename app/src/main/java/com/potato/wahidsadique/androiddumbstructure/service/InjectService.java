package com.potato.wahidsadique.androiddumbstructure.service;

import android.content.Context;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.model.config.ApiClient;
import com.potato.wahidsadique.androiddumbstructure.model.config.DbConfig;

/**
 * Created by wahid.sadique on 9/12/2017.
 */

public class InjectService {
    private Context context;
    private ApiInterface apiInterface;
    private DbInterface dbInterface;

    public InjectService(Context context) {
        this.context = context;
        this.apiInterface = ApiClient.getClient().create(ApiInterface.class);
        this.dbInterface = new DbService(new DbCrud(),new DbConfig(context));
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public DbInterface getDbInterface() {
        return dbInterface;
    }
}
