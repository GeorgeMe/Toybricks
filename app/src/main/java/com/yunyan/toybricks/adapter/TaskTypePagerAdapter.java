package com.yunyan.toybricks.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yunyan.toybricks.fragment.ToyBricksGridFragment;

import java.util.Random;

public class TaskTypePagerAdapter extends FragmentPagerAdapter {

    private int pagerCount = 2;

    Context ctx;

       final Fragment[] fragments =
       {

       };

    private Random random = new Random();

    public TaskTypePagerAdapter(FragmentManager fm, Context ctx)
    {
        super(fm);

        this.ctx = ctx;

    }

    @Override public Fragment getItem(int i)
    {
        if(i==0)
        {
            return  new ToyBricksGridFragment();
        }
        else
        {
            return new ToyBricksGridFragment();
        }
    }

    @Override public int getCount() {
        return pagerCount;
    }



}