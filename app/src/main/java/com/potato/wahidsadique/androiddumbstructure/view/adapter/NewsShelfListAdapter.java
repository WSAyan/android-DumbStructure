package com.potato.wahidsadique.androiddumbstructure.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.service.InjectService;

import java.util.ArrayList;

/**
 * Created by wahid.sadique on 9/14/2017.
 */

public class NewsShelfListAdapter extends RecyclerView.Adapter<NewsShelfListAdapter.ViewHolder> {
    private Context context;
    private InjectService injectService;
    private DataTable dataTable;

    public NewsShelfListAdapter(Context context) {
        this.context = context;
        injectService = new InjectService();
        injectService.setiDbService(context);
        dataTable = injectService.getiDbService().getFavourites();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_shelf_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
