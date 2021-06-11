package com.example.gener.rongyundemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class RongAdapter extends FragmentPagerAdapter {
    private List<?> mFragments;

    public RongAdapter(FragmentManager fm, List<?> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
