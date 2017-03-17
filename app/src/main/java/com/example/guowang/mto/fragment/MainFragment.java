package com.example.guowang.mto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.mViewPagerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @Bind(R.id.rb_music)
    RadioButton rbMusic;
    @Bind(R.id.rb_musics)
    RadioButton rbMusics;
    @Bind(R.id.rb_top)
    RadioButton rbTop;
    @Bind(R.id.rb_music_line)
    View rbMusicLine;
    @Bind(R.id.rb_musics_line)
    View rbMusicsLine;
    @Bind(R.id.rb_top_line)
    View rbTopLine;
    @Bind(R.id.vp_music)
    ViewPager vpMusic;

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    FragmentManager fragmentManager;
    MusicsFragment mMusicsFragment;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;

    }

    private void initView() {
        mMusicsFragment = new MusicsFragment();
        fragmentArrayList.add(mMusicsFragment);
        fragmentManager = getFragmentManager();
        mViewPagerAdapter VP_Adapter = new mViewPagerAdapter(fragmentManager, fragmentArrayList);
        vpMusic.setAdapter(VP_Adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rb_music, R.id.rb_musics, R.id.rb_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_music:
                rbMusicLine.setVisibility(View.VISIBLE);
                rbMusicsLine.setVisibility(View.INVISIBLE);
                rbTopLine.setVisibility(View.INVISIBLE);
                break;
            case R.id.rb_musics:
                rbMusicLine.setVisibility(View.INVISIBLE);
                rbMusicsLine.setVisibility(View.VISIBLE);
                rbTopLine.setVisibility(View.INVISIBLE);
                break;
            case R.id.rb_top:
                rbMusicLine.setVisibility(View.INVISIBLE);
                rbMusicsLine.setVisibility(View.INVISIBLE);
                rbTopLine.setVisibility(View.VISIBLE);
                break;

        }

    }


}
