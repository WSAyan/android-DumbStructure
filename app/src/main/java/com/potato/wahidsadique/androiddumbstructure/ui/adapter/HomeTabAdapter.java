package com.potato.wahidsadique.androiddumbstructure.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.ui.fragment.NewsShelfFragment;
import com.potato.wahidsadique.androiddumbstructure.ui.fragment.NewsSourceFragment;

/**
 * Created by wahid.sadique on 8/30/2017.
 */

public class HomeTabAdapter extends FragmentPagerAdapter {
    private Context context;

    public HomeTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new NewsSourceFragment();
                break;
            case 1:
                fragment = new NewsShelfFragment();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.news_tab);
            case 1:
                return context.getString(R.string.shelf_tab);
            default:
                return null;
        }
    }
}
