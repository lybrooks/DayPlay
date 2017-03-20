package com.example.guowang.mto.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.guowang.mto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlaylistActicity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private ActionBar actionBar;
    private boolean isLocalPlaylist;

    private int mStatusSize;

    private String albumPath, playlistName, playlistDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.actionbar_back);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("歌单");
        mToolbar.setPadding(0, mStatusSize, 0, 0);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (!isLocalPlaylist) {
            mToolbar.setSubtitle(playlistDetail);
        }
    }
}
