package com.ramsoft.viewswipe;
/*
 * 
 * Copyright (C) 2020 Murali Mohan
 * 
 **/

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    private CustomViewPager mPager;
    boolean toggle = true;
    protected static final String[] CONTENT1 = new String[]{"Pager Carousel 1", "Pager Carousel 2",
            "Pager Carousel 2", "Pager Carousel 4"};
    protected static final String[] CONTENT2 = new String[]{"Title 1", "Title 2","Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"};
    protected static final int[] COLOR_CODES = {R.color.light_gray,R.color.light_green,R.color.light_red,R.color.light_ceyon,R.color.light_pink,R.color.light_blue,
            R.color.light_yellow,R.color.light_purple,R.color.light_gray};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initKKViewPager();

    }

    private void initKKViewPager() {
        mPager = (CustomViewPager) findViewById(R.id.custom_view_pager);
        mPager.setAdapter(new ItemFragmentAdapter(getSupportFragmentManager(), MainActivity.this, CONTENT2,COLOR_CODES));
        mPager.setAnimationEnabled(true);
        mPager.setFadeEnabled(true);
        mPager.setFadeFactor(0.6f);

    }
    private void updateNoOfCards() {
        if (toggle = !toggle) {
            mPager.setAdapter(new ItemFragmentAdapter(getSupportFragmentManager(), MainActivity.this, CONTENT2,COLOR_CODES));
        } else {
            mPager.setAdapter(new ItemFragmentAdapter(getSupportFragmentManager(), MainActivity.this, CONTENT1,COLOR_CODES));
        }
    }
}
