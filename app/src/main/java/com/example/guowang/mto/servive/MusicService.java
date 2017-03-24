package com.example.guowang.mto.servive;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


import java.io.IOException;

public class MusicService extends Service {
    String Path;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        final String path = "http://zhangmenshiting.baidu.com/data2/music/49078476/49078476.mp3?xcode=c8acdc13899ac4d7b6f28ebc1a3b5868";
        final MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(Path);
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
