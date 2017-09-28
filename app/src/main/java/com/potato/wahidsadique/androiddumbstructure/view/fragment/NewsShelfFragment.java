package com.potato.wahidsadique.androiddumbstructure.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.model.binder.DataTable;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Source;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Sources;
import com.potato.wahidsadique.androiddumbstructure.service.ApiInterface;
import com.potato.wahidsadique.androiddumbstructure.service.DbInterface;
import com.potato.wahidsadique.androiddumbstructure.service.InjectService;
import com.potato.wahidsadique.androiddumbstructure.view.adapter.NewsShelfListAdapter;
import com.potato.wahidsadique.androiddumbstructure.view.adapter.NewsSourceListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsShelfFragment extends Fragment {
    private RecyclerView newsShelfRecyclerView;
    private Context context;
    private InjectService injectService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelf, container, false);
        initializeWidgets(view);
        initializeData();
        return view;
    }

    private void initializeWidgets(View view) {
        newsShelfRecyclerView = (RecyclerView) view.findViewById(R.id.shelf_list_recyclerView);
    }

    private void initializeData() {
        context = getActivity();
        injectService = new InjectService(context);
    }


    private void createList() {
        NewsShelfListAdapter newsShelfListAdapter = new NewsShelfListAdapter(context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        newsShelfRecyclerView.setLayoutManager(layoutManager);
        newsShelfRecyclerView.setItemAnimator(new DefaultItemAnimator());
        newsShelfRecyclerView.setAdapter(newsShelfListAdapter);
        newsShelfListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        createList();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
