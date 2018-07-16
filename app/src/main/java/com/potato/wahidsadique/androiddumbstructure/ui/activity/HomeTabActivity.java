package com.potato.wahidsadique.androiddumbstructure.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.presenter.AppPresenter;
import com.potato.wahidsadique.androiddumbstructure.ui.adapter.HomeTabAdapter;
import com.potato.wahidsadique.androiddumbstructure.utility.GlobalConstants;
import com.potato.wahidsadique.androiddumbstructure.utility.SharedPrefUtils;

public class HomeTabActivity extends AppCompatActivity {
    private HomeTabAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Context context;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
        initializeWidgets();
        initializeData();
        eventListeners();
    }

    private void initializeWidgets() {
        toolbar = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabs);
    }

    private void initializeData() {
        setSupportActionBar(toolbar);

        context = this;
        mSectionsPagerAdapter = new HomeTabAdapter(getSupportFragmentManager(), context);

        assert mViewPager != null;
        mViewPager.setAdapter(mSectionsPagerAdapter);

        assert tabLayout != null;
        tabLayout.setupWithViewPager(mViewPager);

        sharedPreferences = new AppPresenter().getSharedPrefInterface(context);
        sharedPreferences.edit().putString(SharedPrefUtils._API_KEY, GlobalConstants.API_KEY).apply();
        sharedPreferences.edit().putString(SharedPrefUtils._LANGUAGE, GlobalConstants.ENGLISH).apply();
    }

    private void eventListeners() {
        //event listeners here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
