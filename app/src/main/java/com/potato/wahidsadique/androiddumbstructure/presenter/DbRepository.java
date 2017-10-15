package com.potato.wahidsadique.androiddumbstructure.presenter;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DataRow;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.model.config.DbConfig;

/**
 * Created by wahid.sadique on 9/11/2017.
 */

public class DbRepository implements DbInterface {
    private DbCrud dbCrud;
    private DbConfig dbConfig;

    public DbRepository(DbCrud dbCrud, DbConfig dbConfig) {
        this.dbCrud = dbCrud;
        this.dbConfig = dbConfig;
    }

    @Override
    public DataTable getFavourites() {
        String selectQuery = "SELECT * FROM " + dbConfig.getTableFavourites();
        return dbCrud.selectData(selectQuery, null, dbConfig.getSqLiteDatabase());
    }

    @Override
    public int markFavourites(String id, String name, String description, String url) {
        DataTable dataTable = new DataTable(DbConfig.getTableFavourites());
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
        String tableName = DbConfig.getTableFavourites();
        String[] args = {id};
        String whereClause = " id = ? ";
        return dbCrud.deleteData(tableName, whereClause, args, dbConfig.getSqLiteDatabase());
    }
}
