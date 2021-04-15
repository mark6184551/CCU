package com.example.gggg.chang_an;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments ;
    List<String> titles;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles =titles;
    }
    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }
    @Override
    public int getCount(){
        return fragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return titles.get(position);
    }
}
