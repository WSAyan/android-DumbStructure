package com.potato.wahidsadique.androiddumbstructure.config.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class DbConfig {
    private DbHelper dbHelper;

    public DbConfig(Context context, String dbName, int dbVersion) {
        this.dbHelper = new DbHelper(context, dbName, null, dbVersion);
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return dbHelper.getWritableDatabase();
    }
}
