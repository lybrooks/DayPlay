package com.example.guowang.mto.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guowang.mto.R;
import com.example.guowang.mto.utils.MFGT;

public class SplashActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;

    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(2000);
                        MFGT.gotoMainActivity((Activity) mContext);
//                        startActivity(new Intent(mContext,MainActivity.class));
                        finish();
                    }
                }
        ).start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        MFGT.finish(SplashActivity.this);
    }
}
