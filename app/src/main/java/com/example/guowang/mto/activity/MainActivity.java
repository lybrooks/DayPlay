package com.example.guowang.mto.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.MenuAdapter;
import com.example.guowang.mto.adapter.mViewPagerAdapter;
import com.example.guowang.mto.bean.MenuInfoBean;
import com.example.guowang.mto.fragment.MainFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rlv_menu)
    RecyclerView mRlvMenu;
    @Bind(R.id.activity_main)
    DrawerLayout mDwaermenu;
    ArrayList<MenuInfoBean> MenuInfoList;
    MenuAdapter menuAdapter;
    Context mContext;
    @Bind(R.id.vp_main)
    ViewPager vp_main;

    RadioButton[] mrb;
    int index;


    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    MainFragment mainFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initListener() {

    }


    private void initView() {


        MenuInfoList = new ArrayList<>();
        MenuInfoBean[] beans = {new MenuInfoBean(R.mipmap.topmenu_icn_night, "夜间模式"),
                new MenuInfoBean(R.mipmap.topmenu_icn_skin, "主题换肤"),
                new MenuInfoBean(R.mipmap.topmenu_icn_time, "定时关闭音乐"),
                new MenuInfoBean(R.mipmap.topmenu_icn_vip, "下载歌曲品质"),
                new MenuInfoBean(R.mipmap.topmenu_icn_exit, "退出")};
        for (MenuInfoBean bean : beans) {
            MenuInfoList.add(bean);
            Log.e("main", "" + bean.toString());
        }
        mContext = this;
//        mDwaermenu.setScrimColor(Color.TRANSPARENT);
        menuAdapter = new MenuAdapter(mContext, MenuInfoList, mDwaermenu, mRlvMenu);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRlvMenu.setAdapter(menuAdapter);
        mRlvMenu.setLayoutManager(manager);

        mainFragment = new MainFragment();
        fragmentArrayList.add(mainFragment);
        fragmentManager = getSupportFragmentManager();
        mViewPagerAdapter VP_Adapter = new mViewPagerAdapter(fragmentManager, fragmentArrayList);
//        vp_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                switch (position) {
//                    case 0:
//                        index = 0;
//                        break;
//                    case 1:
//                        index = 1;
//                        break;
//                    case 2:
//                        index = 2;
//                        break;
//                    case 3:
//                        index = 3;
//                        break;
//
//                }
//                setRadioButtonStatus();
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        vp_main.setAdapter(VP_Adapter);




    }

    private void setRadioButtonStatus() {

    }








    @OnClick(R.id.iv_actionbar_menu)
    public void onClick() {
        if (mDwaermenu.isDrawerOpen(mRlvMenu)) {
            mDwaermenu.closeDrawer(mRlvMenu);
        } else {
            mDwaermenu.openDrawer(mRlvMenu);
        }
    }
}
