package com.example.guowang.mto.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.mViewPagerAdapter;
import com.example.guowang.mto.utils.L;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    FragmentManager fragmentManager;
    MusicsFragment mMusicsFragment;
    NewMusicFragment mNewMusicFragment;
    TopsFragment mTopsFragment;
    TabLayout tlMusic;
    ViewPager vpMusic;

    String [] mTitle;

    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tlMusic = (TabLayout) view.findViewById(R.id.tl_music);
        vpMusic = (ViewPager) view.findViewById(R.id.vp_music);
        initView();
        return view;

    }



    private void initView() {
        mTitle = new String[]{"新曲","歌单","排行榜"};
        mMusicsFragment = new MusicsFragment();
        mNewMusicFragment = new NewMusicFragment();
        mTopsFragment = new TopsFragment();

        fragmentArrayList.add(mNewMusicFragment);
        fragmentArrayList.add(mMusicsFragment);
        fragmentArrayList.add(mTopsFragment);

        fragmentManager = getFragmentManager();
        mViewPagerAdapter VP_Adapter = new mViewPagerAdapter(fragmentManager, fragmentArrayList,mTitle);
        vpMusic.setAdapter(VP_Adapter);
        tlMusic.setTabsFromPagerAdapter(VP_Adapter);
        tlMusic.setupWithViewPager(vpMusic);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }









}
