package com.example.guowang.mto.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class mViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    FragmentManager mFragmentManager;
    String[] mTitle =new String[]{};

    public mViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> arrayList,String[] mTitle) {
        super(fm);
        this.fragmentArrayList = arrayList;
        this.mFragmentManager = fm;
        this.mTitle=mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mFragmentManager.beginTransaction().hide(fragmentArrayList.get(position));
    }


}
