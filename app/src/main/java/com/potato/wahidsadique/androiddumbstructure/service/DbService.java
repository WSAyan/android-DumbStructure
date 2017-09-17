package com.potato.wahidsadique.androiddumbstructure.service;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DbCrud;
import com.potato.wahidsadique.androiddumbstructure.model.config.DbConfig;

/**
 * Created by wahid.sadique on 9/11/2017.
 */

public class DbService implements IDbService {
    private DbCrud dbCrud;
    private DbConfig dbConfig;

    public DbService(DbCrud dbCrud, DbConfig dbConfig) {
        this.dbCrud = dbCrud;
        this.dbConfig = dbConfig;
    }

    @Override
    public DataTable getFavourites() {
        String selectQuery = "SELECT * FROM " + dbConfig.getTableFavourites();
        return dbCrud.selectData(selectQuery,null,dbConfig.getSqLiteDatabase());
    }

    @Override
    public int markFavourites() {
        return 0;
    }

    @Override
    public int removeFavourites() {
        return 0;
    }
}
