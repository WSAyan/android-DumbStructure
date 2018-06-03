package com.potato.wahidsadique.androiddumbstructure.config.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.potato.wahidsadique.androiddumbstructure.utility.GlobalConstants;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class DbConfig {
    private DbHelper dbHelper;

    public DbConfig(Context context) {
        this.dbHelper = new DbHelper(context, GlobalConstants.DB_NAME, null, GlobalConstants.DB_VERSION);
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return dbHelper.getWritableDatabase();
    }
}
