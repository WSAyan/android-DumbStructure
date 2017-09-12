package com.potato.wahidsadique.androiddumbstructure.service;

import android.content.Context;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.model.config.DbConfig;

/**
 * Created by wahid.sadique on 9/12/2017.
 */

public class InjectService {
    IRestService iRestService;
    IDbService iDbService;

    public IRestService getiRestService() {
        return iRestService;
    }

    public void setiRestService(Context context) {
        this.iRestService = new RestService(new DbCrud(),new DbConfig(context));
    }

    public IDbService getiDbService() {
        return iDbService;
    }

    public void setiDbService(Context context) {
        this.iDbService = new DbService(new DbCrud(), new DbConfig(context));
    }
}
