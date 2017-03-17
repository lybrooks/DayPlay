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
import com.example.guowang.mto.utils.L;

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
    NewMusicFragment mNewMusicFragment;
    TopsFragment mTopsFragment;
    int index;

    public MainFragment() {
        // Required empty public constructor
    }
    View[] mV ;
    RadioButton mrb[] ;

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
        mV = new View[]{rbMusicLine, rbMusicsLine, rbTopLine};
        mrb= new RadioButton[]{rbMusic, rbMusics, rbTop};
        mMusicsFragment = new MusicsFragment();
        mNewMusicFragment = new NewMusicFragment();
        mTopsFragment = new TopsFragment();

        fragmentArrayList.add(mNewMusicFragment);
        fragmentArrayList.add(mMusicsFragment);
        fragmentArrayList.add(mTopsFragment);

        fragmentManager = getFragmentManager();
        mViewPagerAdapter VP_Adapter = new mViewPagerAdapter(fragmentManager, fragmentArrayList);
        vpMusic.setAdapter(VP_Adapter);

        vpMusic.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        index = 0;
//                        setRbmusic();
                        break;
                    case 1:
                        index = 1;
//                        setRbmusics();
                        break;
                    case 2:
                        index = 2;
//                        setRbtop();
                        break;
                }
                L.e("index=" + index);
                setRadioButtonStatus();


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
                index = 0;
                break;
            case R.id.rb_musics:
                index = 1;
                break;
            case R.id.rb_top:
                index = 2;
                break;
        }
        setViewPage();


    }


    private void setRadioButtonStatus() {
        for (int i = 0; i < mV.length; i++) {
            if (i != index) {
                rbMusic.setChecked(false);
                mV[i].setVisibility(View.INVISIBLE);
            } else {
                mrb[i].setChecked(true);
                mV[i].setVisibility(View.VISIBLE);
            }
        }
    }

    private void setViewPage() {
        for (int i = 0; i < mV.length; i++) {
            if (i == index) {
                vpMusic.setCurrentItem(i);
            }
        }
    }




}
