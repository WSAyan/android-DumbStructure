package com.potato.wahidsadique.androiddumbstructure.ui.fragment;


import android.app.ProgressDialog;
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
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Source;
import com.potato.wahidsadique.androiddumbstructure.model.pojo.Sources;
import com.potato.wahidsadique.androiddumbstructure.presenter.InjectPresenter;
import com.potato.wahidsadique.androiddumbstructure.ui.adapter.NewsSourceListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsSourceFragment extends Fragment {
    private RecyclerView newsSourceRecyclerView;
    private Context context;
    private InjectPresenter injectPresenter;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initializeWidgets(view);
        initializeData();
        return view;
    }

    private void initializeWidgets(View view) {
        newsSourceRecyclerView = (RecyclerView) view.findViewById(R.id.source_list_recyclerView);
    }

    private void initializeData() {
        context = getActivity();
        injectPresenter = new InjectPresenter();
        progressDialog = new ProgressDialog(context);
    }

    private void createList(List<Source> sources) {
        NewsSourceListAdapter newsSourceListAdapter = new NewsSourceListAdapter(context, sources);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        newsSourceRecyclerView.setLayoutManager(layoutManager);
        newsSourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        newsSourceRecyclerView.setAdapter(newsSourceListAdapter);
        newsSourceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        progressDialog.setMessage("Loading");
        progressDialog.show();
        Call<Sources> call = injectPresenter.getApiInterface().getNewsSources("en");
        call.enqueue(new Callback<Sources>() {
            @Override
            public void onResponse(Call<Sources> call, Response<Sources> response) {
                createList(response.body().getSources());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Sources> call, Throwable t) {

            }
        });
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
