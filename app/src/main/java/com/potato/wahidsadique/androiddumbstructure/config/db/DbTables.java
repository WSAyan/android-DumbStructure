package com.potato.wahidsadique.androiddumbstructure.config.db;

/**
 * Created by User on 11/7/2017.
 */

public final class DbTables {
    public static final String FAVOURITES_TABLE = "favourites";
    public static final String EXAMPLE_TABLE = "example";
    public static final String ANOTHER_EXAMPLE_TABLE = "another_example";

    protected static final String[] CREATE_TABLES = {
            "   CREATE TABLE " + FAVOURITES_TABLE + " (" +
                    "   id varchar(50) UNIQUE, " +
                    "   name varchar(50), " +
                    "   description varchar(200), " +
                    "   url varchar(200)" +
                    "   );"
            ,
            "   CREATE TABLE " + EXAMPLE_TABLE + " (" +
                    "   id varchar(50) UNIQUE, " +
                    "   name varchar(50), " +
                    "   description varchar(200), " +
                    "   url varchar(200)" +
                    "   );"
            ,
            "   CREATE TABLE " + ANOTHER_EXAMPLE_TABLE + " (" +
                    "   id varchar(50) UNIQUE, " +
                    "   name varchar(50), " +
                    "   description varchar(200), " +
                    "   url varchar(200)" +
                    "   );"
    };
}
