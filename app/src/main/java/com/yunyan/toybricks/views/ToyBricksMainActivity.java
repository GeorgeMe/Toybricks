package com.yunyan.toybricks.views;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.yunyan.toybricks.R;
import com.yunyan.toybricks.adapter.TaskTypePagerAdapter;

/**
 * Created by George on 2015/9/6.
 */
public class ToyBricksMainActivity extends ActionBarActivity {
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toybricks_activity_main);
        pager=(ViewPager)findViewById(R.id.viewpager);
        TaskTypePagerAdapter pagerAdapter = new TaskTypePagerAdapter(getSupportFragmentManager(),ToyBricksMainActivity.this);
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
