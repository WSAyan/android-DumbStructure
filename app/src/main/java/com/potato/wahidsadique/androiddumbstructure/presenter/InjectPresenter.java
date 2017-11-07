package com.potato.wahidsadique.androiddumbstructure.presenter;

import android.content.Context;

import com.potato.wahidsadique.androiddumbstructure.config.db.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.config.api.ApiClient;
import com.potato.wahidsadique.androiddumbstructure.config.db.DbConfig;

/**
 * Created by wahid.sadique on 9/12/2017.
 */

public class InjectPresenter {
    private ApiInterface apiInterface;
    private DbInterface dbInterface;

    public InjectPresenter(Context context) {
        this.apiInterface = ApiClient.getClient().create(ApiInterface.class);
        this.dbInterface = new DbRepository(new DbCrud(),new DbConfig(context));
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public DbInterface getDbInterface() {
        return dbInterface;
    }
}
