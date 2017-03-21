package com.example.guowang.mto.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.guowang.mto.R;
import com.example.guowang.mto.activity.MainActivity;
import com.example.guowang.mto.activity.PlaylistActicity;
import com.example.guowang.mto.bean.GedanInfoBean;


/**
 * 实现跳转
 */
public class MFGT {
    public static void finish(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void gotoMainActivity(Activity context) {
        startActivity(context, MainActivity.class);
    }

    public static void startActivity(Activity context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        startActivity(context, intent);
    }

    public static void startActivity(Activity context, Intent intent) {
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }


    public static void startActivityForResult(Activity context, Intent intent, int requestCode) {
        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }


    public static void goPlaylistActicity(Context mContext, GedanInfoBean infoBean) {
        Intent intent = new Intent(mContext, PlaylistActicity.class);
        intent.putExtra("playlistid", infoBean.getListid());
        intent.putExtra("islocal", false);
        intent.putExtra("albumart", infoBean.getPic_300());
        intent.putExtra("playlistname", infoBean.getTitle());
        intent.putExtra("playlistDetail", infoBean.getTag());
        intent.putExtra("playlistcount", infoBean.getListenum());
        startActivity((Activity) mContext,intent);

    }
}
