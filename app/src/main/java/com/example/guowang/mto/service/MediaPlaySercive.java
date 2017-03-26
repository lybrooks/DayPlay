package com.example.guowang.mto.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.guowang.mto.bean.SongBean;
import com.example.guowang.mto.bean.SongInfoBean;
import com.example.guowang.mto.net.DownLoadData;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class MediaPlaySercive extends Service {
    String path;
    MediaPlayer player;

    public MediaPlaySercive() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        L.e("aaaaa");
//        EventBus.getDefault().register(this);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String songId = intent.getStringExtra("song_Id");
        L.e("songId=" + songId);
        if (songId != null) {
            DownLoadData.LoadSongInfo(this, Long.valueOf(songId), new OkHttpUtils.OnCompleteListener<SongInfoBean>() {
                        @Override
                        public void onSuccess(SongInfoBean result) {
                            path = result.getSongurl().getUrl().get(0).getShow_link();
                            L.e("path=" + path);
                            starPlay(path);
                        }

                        @Override
                        public void onError(String error) {

                        }
                    }
            );
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void starPlay(final String path) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (path != null) {
                    String mPath = "aaa";
                    if (!mPath.equals(path)) {
                        mPath = path;
                        Log.d("test", path);
                        while (true) {
                            if (player == null) {
                                player = new MediaPlayer();
                                try {
                                    player.setDataSource(mPath);
                                    player.prepare();
                                    if (player != null) {
                                        player.start();
                                        break;
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                player.release();
                                player = null;
                            }
                        }
                    }


                }

            }
        }).start();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
