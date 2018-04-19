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
import com.potato.wahidsadique.androiddumbstructure.presenter.ApiInterface;
import com.potato.wahidsadique.androiddumbstructure.presenter.AppPresenter;
import com.potato.wahidsadique.androiddumbstructure.presenter.DbInterface;
import com.potato.wahidsadique.androiddumbstructure.ui.adapter.NewsSourceListAdapter;
import com.potato.wahidsadique.androiddumbstructure.utility.GlobalConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsSourceFragment extends Fragment {
    private RecyclerView newsSourceRecyclerView;
    private Context context;
    private DbInterface dbInterface;
    private ApiInterface apiInterface;
    private ProgressDialog progressDialog;
    private Call<Sources> sourcesCall;
    private List<Source> sources;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initializeWidgets(view);
        initializeData();
        return view;
    }

    private void initializeWidgets(View view) {
        newsSourceRecyclerView = view.findViewById(R.id.source_list_recyclerView);
    }

    private void initializeData() {
        context = getActivity();
        AppPresenter appPresenter = new AppPresenter();
        dbInterface = appPresenter.getDbInterface(context);
        apiInterface = appPresenter.getApiInterface();
        progressDialog = new ProgressDialog(context);
        downloadList();
    }

    private void createList(List<Source> sources) {
        NewsSourceListAdapter newsSourceListAdapter = new NewsSourceListAdapter(context, dbInterface, sources);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        newsSourceRecyclerView.setLayoutManager(layoutManager);
        newsSourceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        newsSourceRecyclerView.setAdapter(newsSourceListAdapter);
        newsSourceListAdapter.notifyDataSetChanged();
    }

    private void downloadList() {
        progressDialog.setMessage("Loading");
        progressDialog.show();
        sourcesCall = apiInterface.getNewsSources("en");
        sourcesCall.enqueue(new Callback<Sources>() {
            @Override
            public void onResponse(Call<Sources> call, Response<Sources> response) {
                if(response.code() == GlobalConstants.HTTP_STATUS_OK){
                    sources = response.body().getSources();
                    createList(response.body().getSources());
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Sources> call, Throwable t) {
                progressDialog.dismiss();
                sourcesCall.cancel();
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && sources != null) {
            createList(sources);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
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
        flush();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flush();

    }

    private void flush() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (sourcesCall != null) {
            sourcesCall.cancel();
        }
    }
}
