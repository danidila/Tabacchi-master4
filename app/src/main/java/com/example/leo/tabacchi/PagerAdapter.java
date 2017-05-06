package com.example.leo.tabacchi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franc on 05/05/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter{
    List<Fragment> fragmentList=new ArrayList<Fragment>();
    List<String> fragmentTitle=new ArrayList<String>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment f, String t){
        fragmentList.add(f);
        fragmentTitle.add(t);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
    }
}

