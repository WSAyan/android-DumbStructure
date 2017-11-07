package com.potato.wahidsadique.androiddumbstructure.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Source;
import com.potato.wahidsadique.androiddumbstructure.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahid.sadique on 9/17/2017.
 */

public class NewsSourceListAdapter extends RecyclerView.Adapter<NewsSourceListAdapter.ViewHolder> {
    private Context context;
    private List<Source> sources = new ArrayList<>();
    private InjectPresenter injectPresenter;

    public NewsSourceListAdapter(Context context, List<Source> sources) {
        this.context = context;
        this.sources = sources;
        this.injectPresenter = new InjectPresenter();
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
        final boolean isFavourite = injectPresenter.getDbInterface(context).checkFavourites(id);
        Bitmap bitmap;
        if (isFavourite) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), android.R.drawable.star_on);
        } else {
            bitmap = BitmapFactory.decodeResource(context.getResources(), android.R.drawable.star_off);
        }

        holder.favImageView.setImageBitmap(bitmap);
        holder.nameTextView.setText(name);
        holder.descriptionTextView.setText(description);
        holder.favImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFavourite) {
                    injectPresenter.getDbInterface(context).markFavourites(id, name, description, url);
                    notifyDataSetChanged();
                }else{
                    injectPresenter.getDbInterface(context).removeFavourites(id);
                    notifyDataSetChanged();
                }
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
