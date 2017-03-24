package com.example.guowang.mto.activity;

import android.os.SystemClock;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.guowang.mto.R;
import com.example.guowang.mto.fragment.PlayFragment;
import com.example.guowang.mto.utils.L;

public class BaseActivity extends AppCompatActivity {
    private PlayFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        showQuickControl(true);
    }

    int n = 0;

    private void initView() {

    }


//    public Runnable mUpdateProgress = new Runnable() {

//        @Override
//        public void run() {

//            if (duration > 0 && duration < 627080716){

//        }
//    }

//            }
//
//            if (MusicPlayer.isPlaying()) {
//                mProgress.postDelayed(mUpdateProgress, 50);
//            }else {
//                mProgress.removeCallbacks(mUpdateProgress);
//            }

//}
//};

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
