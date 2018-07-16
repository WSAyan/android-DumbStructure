package com.potato.wahidsadique.androiddumbstructure.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.presenter.IDbInteractor;
import com.potato.wahidsadique.androiddumbstructure.ui.activity.NewsActivity;
import com.potato.wahidsadique.androiddumbstructure.utility.GlobalConstants;

/**
 * Created by wahid.sadique on 9/14/2017.
 */

public class NewsShelfListAdapter extends RecyclerView.Adapter<NewsShelfListAdapter.ViewHolder> {
    private DataTable dataTable;
    private IDbInteractor dbInteractor;
    private Context context;

    public NewsShelfListAdapter(IDbInteractor dbInteractor) {
        this.dbInteractor = dbInteractor;
        this.dataTable = dbInteractor.getFavourites();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_shelf_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final int currentPosition = position;

        final String id = dataTable.get(position).get("id").toString();
        final String name = dataTable.get(position).get("name").toString();
        final String description = dataTable.get(position).get("description").toString();
        final String url = dataTable.get(position).get("url").toString();

        holder.nameTextView.setText(name);
        holder.descriptionTextView.setText(description);
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int status = dbInteractor.removeFavourites(id);
                if (status > 0) {
                    dataTable.remove(currentPosition);
                    notifyDataSetChanged();
                }
            }
        });
        holder.shelfItemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (url != null) {
                    Intent intent = new Intent(context, NewsActivity.class);
                    intent.putExtra(GlobalConstants.EXT_TAG_URL, url);
                    intent.putExtra(GlobalConstants.EXT_TAG_NAME, name);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTable.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView nameTextView, descriptionTextView;
        protected ImageView deleteImageView;
        protected LinearLayout shelfItemLinearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            initializeWidgets(itemView);
        }

        private void initializeWidgets(View itemView) {
            nameTextView = itemView.findViewById(R.id.shelf_item_name_textView);
            descriptionTextView = itemView.findViewById(R.id.shelf_item_description_textView);
            deleteImageView = itemView.findViewById(R.id.shelf_item_delete_imageView);
            shelfItemLinearLayout = itemView.findViewById(R.id.shelf_item_LinearLayout);
        }
    }
}
