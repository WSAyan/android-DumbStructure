package com.potato.wahidsadique.androiddumbstructure.presenter;

import android.content.Context;

import com.potato.wahidsadique.androiddumbstructure.config.db.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.config.ApiClient;
import com.potato.wahidsadique.androiddumbstructure.config.db.DbConfig;

/**
 * Created by wahid.sadique on 9/12/2017.
 */

public class AppPresenter {

    public ApiInterface getApiInterface() {
        return ApiClient.getClient().create(ApiInterface.class);
    }

    public DbInterface getDbInterface(Context context) {
        return new DbRepository(new DbCrud(), new DbConfig(context));
    }
}
