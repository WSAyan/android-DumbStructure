package com.potato.wahidsadique.androiddumbstructure.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.presenter.InjectPresenter;

/**
 * Created by wahid.sadique on 9/14/2017.
 */

public class NewsShelfListAdapter extends RecyclerView.Adapter<NewsShelfListAdapter.ViewHolder> {
    private Context context;
    private InjectPresenter injectPresenter;
    private DataTable dataTable = new DataTable();

    public NewsShelfListAdapter(Context context) {
        this.context = context;
        this.injectPresenter = new InjectPresenter();
        this.dataTable = injectPresenter.getDbInterface(context).getFavourites();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_shelf_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
                int status = injectPresenter.getDbInterface(context).removeFavourites(id);
                if (status > 0) {
                    dataTable.remove(currentPosition);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTable.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descriptionTextView;
        ImageView deleteImageView;

        ViewHolder(View itemView) {
            super(itemView);
            initializeWidgets(itemView);
        }

        private void initializeWidgets(View itemView) {
            nameTextView = (TextView) itemView.findViewById(R.id.shelf_item_name_textView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.shelf_item_description_textView);
            deleteImageView = (ImageView) itemView.findViewById(R.id.shelf_item_delete_imageView);
        }
    }
}
