package com.funstuff.discoverzimbabwe.project.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by phiby on 29/10/17.
 */

public class MyFragPagerAdapter extends FragmentPagerAdapter {

    //Array list of all fragments
    //thus here the views should return the size and position of the fragments
    //such as title and size of list in the fragment
    ArrayList<Fragment> fragments = new ArrayList<>();

    public MyFragPagerAdapter (FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment (Fragment f){
        fragments.add(f);
    }


    //Here we declare the titles of all the tabs and confine them to string values.
    public CharSequence getPageTitle(int position){
        return fragments.get(position).toString();
    }
}
