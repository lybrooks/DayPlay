package com.example.guowang.mto.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guowang.mto.R;
import com.example.guowang.mto.fragment.PlayFragment;

public class BaseActivity extends AppCompatActivity {
    private PlayFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showQuickControl(true);
    }

    private void showQuickControl(boolean show) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (show) {
            if (fragment == null) {
                fragment = PlayFragment.newInstance();
                ft.add(R.id.bottom_container, fragment).commitAllowingStateLoss();
            } else {
                ft.show(fragment).commitAllowingStateLoss();
            }
        } else {
            if (fragment != null)
                ft.hide(fragment).commitAllowingStateLoss();
        }
    }
}
