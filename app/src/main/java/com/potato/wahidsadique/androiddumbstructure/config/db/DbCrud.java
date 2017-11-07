package com.potato.wahidsadique.androiddumbstructure.config.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DataRow;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class DbCrud {
    public DataTable selectData(String query, String[] args, SQLiteDatabase sqLiteDatabase) {
        DataTable dataTable = new DataTable();
        Cursor cursor = sqLiteDatabase.rawQuery(query, args);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnCount = cursor.getColumnCount();
                do {
                    DataRow dataRow = new DataRow();
                    for (int i = 0; i < columnCount; i++) {
                        dataRow.put(cursor.getColumnName(i), cursor.getString(i));
                    }
                    if (dataRow.size() > 0) {
                        dataTable.add(dataRow);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        sqLiteDatabase.close();
        return dataTable;
    }

    public int insertData(DataTable dataTable, SQLiteDatabase sqLiteDatabase) {
        long status = -500;
        String table = dataTable.getTableName();
        sqLiteDatabase.beginTransaction();
        for (DataRow dataRow : dataTable) {
            ContentValues contentValues = dataRow.getContentValues();
            status = sqLiteDatabase.insert(table, null, contentValues);
        }
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
        sqLiteDatabase.close();
        return (int) status;
    }

    public int updateData(String tableName, DataRow dataRow, String whereClause, String[] args, SQLiteDatabase sqLiteDatabase) {
        int status = -1;
        sqLiteDatabase.beginTransaction();
        ContentValues contentValues = dataRow.getContentValues();
        status = sqLiteDatabase.update(tableName, contentValues, whereClause, args);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
        sqLiteDatabase.close();
        return status;
    }

    public int deleteData(String tableName, String whereClause, String[] args, SQLiteDatabase sqLiteDatabase) {
        int status = -1;
        sqLiteDatabase.beginTransaction();
        status = sqLiteDatabase.delete(tableName, whereClause, args);
        sqLiteDatabase.setTransactionSuccessful();
        sqLiteDatabase.endTransaction();
        sqLiteDatabase.close();
        return status;
    }

}
