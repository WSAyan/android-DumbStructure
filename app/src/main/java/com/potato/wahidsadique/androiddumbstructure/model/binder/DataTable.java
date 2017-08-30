package com.potato.wahidsadique.androiddumbstructure.model.binder;

import java.util.ArrayList;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class DataTable extends ArrayList<DataRow> {
    private String tableName;

    public DataTable() {
        super();
    }

    public DataTable(String tableName) {
        super();
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
