package com.example.guowang.mto.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;


import java.io.IOException;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class MusicPlay extends AppCompatActivity {
    public MusicPlay(Context mContext, String path) {
        this.mContext = mContext;
        this.path = path;
    }

    Context mContext;
    String path;

    public void start() {
//        Intent intent = new Intent();
//        intent.putExtra("path", path);
//        intent.setClass(mContext, MusicService.class);
//        startService(intent);

        //final String path = "http://zhangmenshiting.baidu.com/data2/music/49078476/49078476.mp3?xcode=c8acdc13899ac4d7b6f28ebc1a3b5868";
        final MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }

            }
        }).start();
    }

}
