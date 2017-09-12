package com.potato.wahidsadique.androiddumbstructure.model.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

class DbHelper extends SQLiteOpenHelper {

    DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createFavouritesSql = "" +
                "   CREATE TABLE favourites (" +
                "   id varchar(50), " +
                "   name varchar(50), " +
                "   description varchar(200), " +
                "   url varchar(200)" +
                "   );";
        sqLiteDatabase.execSQL(createFavouritesSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
