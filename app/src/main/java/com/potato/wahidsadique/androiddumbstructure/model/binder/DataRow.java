package com.potato.wahidsadique.androiddumbstructure.model.binder;

import android.content.ContentValues;

import java.util.HashMap;


/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class DataRow extends HashMap<String, Object> {
    public Object add(String column, Object value) {
        return put(column, value);
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        for (Entry entry : this.entrySet()) {
            if (entry.getValue() == null) {
                contentValues.putNull(entry.getKey().toString());
            } else {
                contentValues.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return contentValues;
    }
}
