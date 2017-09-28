package com.potato.wahidsadique.androiddumbstructure.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Source;
import com.potato.wahidsadique.androiddumbstructure.service.InjectService;
import com.potato.wahidsadique.androiddumbstructure.view.activity.HomeTabActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wahid.sadique on 9/17/2017.
 */

public class NewsSourceListAdapter extends RecyclerView.Adapter<NewsSourceListAdapter.ViewHolder> {
    private Context context;
    private List<Source> sources = new ArrayList<>();
    private InjectService injectService;

    public NewsSourceListAdapter(Context context, List<Source> sources) {
        this.context = context;
        this.sources = sources;
        this.injectService = new InjectService(context);
    }

    @Override
    public NewsSourceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_source_item, parent, false);
        return new NewsSourceListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsSourceListAdapter.ViewHolder holder, int position) {
        final String id = sources.get(position).getId();
        final String name = sources.get(position).getName();
        final String description = sources.get(position).getDescription();
        final String url = sources.get(position).getUrl();
        holder.nameTextView.setText(name);
        holder.descriptionTextView.setText(description);
        holder.favImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                injectService.getDbInterface().markFavourites(id, name, description, url);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sources.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descriptionTextView;
        ImageView favImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            initializeWidgets(itemView);
        }

        private void initializeWidgets(View itemView) {
            nameTextView = (TextView) itemView.findViewById(R.id.source_item_name_textView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.source_item_description_textView);
            favImageView = (ImageView) itemView.findViewById(R.id.source_item_fav_imageView);
        }
    }
}
