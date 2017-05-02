package com.leoyou.appleo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    List<String> title;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments,List<String> title) {
        super(fm);
        this.fragments=fragments;
        this.title=title;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
