package com.potato.wahidsadique.androiddumbstructure.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.presenter.AppPresenter;
import com.potato.wahidsadique.androiddumbstructure.presenter.IDbInteractor;
import com.potato.wahidsadique.androiddumbstructure.ui.adapter.NewsShelfListAdapter;

public class NewsShelfFragment extends Fragment {
    private RecyclerView newsShelfRecyclerView;
    private Context context;
    private IDbInteractor dbInteractor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shelf, container, false);
        initializeWidgets(view);
        initializeData();
        return view;
    }

    private void initializeWidgets(View view) {
        newsShelfRecyclerView = view.findViewById(R.id.shelf_list_recyclerView);
    }

    private void initializeData() {
        context = getActivity();
        AppPresenter appPresenter = new AppPresenter();
        dbInteractor = appPresenter.getDbInterface(context);
    }


    private void createList() {
        NewsShelfListAdapter newsShelfListAdapter = new NewsShelfListAdapter(dbInteractor);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        newsShelfRecyclerView.setLayoutManager(layoutManager);
        newsShelfRecyclerView.setItemAnimator(new DefaultItemAnimator());
        newsShelfRecyclerView.setAdapter(newsShelfListAdapter);
        newsShelfListAdapter.notifyDataSetChanged();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (context != null) {
            createList();
        }

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
