package com.potato.wahidsadique.androiddumbstructure.presenter;

import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public interface IDbInteractor {
    DataTable getFavourites();

    int markFavourites(String id, String name, String description, String url);

    int removeFavourites(String id);

    boolean checkFavourites(String id);
}
