package com.potato.wahidsadique.androiddumbstructure.utility;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class SessionManager {
    private static final int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "NAME";
    private static final String AUTH_CODE = "AUTH_CODE";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setAuthCode(String authCode) {
        editor.putString(AUTH_CODE, authCode);
        editor.commit();
    }

    public String getAuthCode(){
        return sharedPreferences.getString(AUTH_CODE, null);
    }
}
