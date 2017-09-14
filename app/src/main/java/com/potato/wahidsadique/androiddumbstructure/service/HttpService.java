package com.potato.wahidsadique.androiddumbstructure.service;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.model.config.DbConfig;

/**
 * Created by wahid.sadique on 9/11/2017.
 */

public class HttpService implements IHttpService {
    private DbCrud dbCrud;
    private DbConfig dbConfig;

    public HttpService(DbCrud dbCrud, DbConfig dbConfig) {
        this.dbCrud = dbCrud;
        this.dbConfig = dbConfig;
    }
}
