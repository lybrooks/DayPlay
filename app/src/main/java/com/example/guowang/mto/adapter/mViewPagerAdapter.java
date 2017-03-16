package com.example.guowang.mto.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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

    public mViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> arrayList) {
        super(fm);
        this.fragmentArrayList = arrayList;
        this.mFragmentManager = fm;
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
    public void destroyItem(ViewGroup container, int position, Object object) {
        mFragmentManager.beginTransaction().hide(fragmentArrayList.get(position));
    }

}
