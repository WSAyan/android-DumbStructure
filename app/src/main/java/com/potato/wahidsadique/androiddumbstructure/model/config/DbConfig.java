package com.potato.wahidsadique.androiddumbstructure.model.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class DbConfig {
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "db_name";
    private Context context;
    private DbHelper dbHelper;

    public DbConfig(Context context) {
        this.context = context;
        this.dbHelper = new DbHelper(context,DB_NAME,null,DB_VERSION);
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return dbHelper.getWritableDatabase();
    }
}
