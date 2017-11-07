package com.potato.wahidsadique.androiddumbstructure.config.db;

/**
 * Created by User on 11/7/2017.
 */

class CreateQueries extends TableNames{
    static final String CREATE_FAVOURITES = "" +
            "   CREATE TABLE " + TABLE_FAVOURITES + " (" +
            "   id varchar(50) UNIQUE, " +
            "   name varchar(50), " +
            "   description varchar(200), " +
            "   url varchar(200)" +
            "   );";
}
