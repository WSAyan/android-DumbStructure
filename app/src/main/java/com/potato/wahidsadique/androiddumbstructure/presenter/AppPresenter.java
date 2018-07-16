package com.potato.wahidsadique.androiddumbstructure.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.potato.wahidsadique.androiddumbstructure.config.ApiClient;
import com.potato.wahidsadique.androiddumbstructure.config.db.DbConfig;
import com.potato.wahidsadique.androiddumbstructure.config.db.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.utility.DbUtils;
import com.potato.wahidsadique.androiddumbstructure.utility.SharedPrefUtils;
import com.potato.wahidsadique.androiddumbstructure.utility.WebUtils;

/**
 * Created by wahid.sadique on 9/12/2017.
 */

public class AppPresenter {

    public IApiInteractor getApiInterface() {
        return ApiClient.getClient(WebUtils.BASE_URL, WebUtils.REQUEST_TIMEOUT).create(IApiInteractor.class);
    }

    public IDbInteractor getDbInterface(Context context) {
        return new DbInteractor(new DbCrud(), new DbConfig(context, DbUtils.DB_NAME, DbUtils.DB_VERSION));
    }

    public SharedPreferences getSharedPrefInterface(Context context) {
        return context.getSharedPreferences(SharedPrefUtils.SPF_NAME, SharedPrefUtils.SPF_MODE);
    }
}
