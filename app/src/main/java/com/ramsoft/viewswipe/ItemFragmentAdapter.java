package com.ramsoft.viewswipe;
/*
 * 
 * Copyright (C) 2020 Murali Mohan
 * 
 *  */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

class ItemFragmentAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] content;
    private int[] colorValues;

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        Object obj = super.instantiateItem(container, position);
        return obj;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (object != null) {
            return ((Fragment) object).getView() == view;
        } else {
            return false;
        }
    }

    public ItemFragmentAdapter(FragmentManager fm, Context context, String[] data, int[] colorCodes) {
        super(fm);
        this.context = context;
        content = data;
        colorValues = colorCodes;
    }

    @Override
    public int getItemPosition(Object object) {
        // Causes adapter to reload all Fragments when
        // notifyDataSetChanged is called
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        return ItemFragment.newInstance(content[position],context, colorValues[position]);
    }

    @Override
    public int getCount() {
        return content == null ? 0 : content.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return content[position];
    }

}