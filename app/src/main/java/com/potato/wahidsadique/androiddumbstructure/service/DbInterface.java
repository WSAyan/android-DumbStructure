package com.potato.wahidsadique.androiddumbstructure.service;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public interface DbInterface {
    DataTable getFavourites();

    int markFavourites();

    int removeFavourites();
}
