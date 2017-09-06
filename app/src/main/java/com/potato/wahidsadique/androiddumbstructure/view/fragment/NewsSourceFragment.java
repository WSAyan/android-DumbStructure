package com.potato.wahidsadique.androiddumbstructure.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.potato.wahidsadique.androiddumbstructure.R;


public class NewsSourceFragment extends Fragment {
    private RecyclerView newsSourceRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initializeWidgets(view);
        return view;
    }

    private void initializeWidgets(View view) {
        newsSourceRecyclerView =  view.findViewById(R.id.source_list_recyclerView);
    }

}
