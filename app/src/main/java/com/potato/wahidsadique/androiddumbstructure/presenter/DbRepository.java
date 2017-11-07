package com.potato.wahidsadique.androiddumbstructure.presenter;

import com.potato.wahidsadique.androiddumbstructure.config.db.TableNames;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataRow;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.config.db.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.config.db.DbConfig;

/**
 * Created by wahid.sadique on 9/11/2017.
 */

class DbRepository extends TableNames implements DbInterface {
    private DbCrud dbCrud;
    private DbConfig dbConfig;

    DbRepository(DbCrud dbCrud, DbConfig dbConfig) {
        this.dbCrud = dbCrud;
        this.dbConfig = dbConfig;
    }

    @Override
    public DataTable getFavourites() {
        String selectQuery = "SELECT * FROM " + TABLE_FAVOURITES;
        return dbCrud.selectData(selectQuery, null, dbConfig.getSqLiteDatabase());
    }

    @Override
    public int markFavourites(String id, String name, String description, String url) {
        DataTable dataTable = new DataTable(TABLE_FAVOURITES);
        DataRow dataRow = new DataRow();
        dataRow.add("id", id);
        dataRow.add("name", name);
        dataRow.add("description", description);
        dataRow.add("url", url);
        dataTable.add(0, dataRow);
        return dbCrud.insertData(dataTable, dbConfig.getSqLiteDatabase());
    }

    @Override
    public int removeFavourites(String id) {
        String tableName = TABLE_FAVOURITES;
        String[] args = {id};
        String whereClause = " id = ? ";
        return dbCrud.deleteData(tableName, whereClause, args, dbConfig.getSqLiteDatabase());
    }
}
