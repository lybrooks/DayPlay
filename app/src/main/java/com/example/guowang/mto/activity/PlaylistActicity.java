package com.example.guowang.mto.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guowang.mto.R;
import com.example.guowang.mto.bean.GeDanDetailBean;
import com.example.guowang.mto.bean.SongBean;
import com.example.guowang.mto.net.DownLoadData;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlaylistActicity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.iv_item_pic)
    ImageView ivItemPic;
    @Bind(R.id.iv_item_count)
    TextView ivItemCount;
    @Bind(R.id.tv_item_dic)
    TextView mTitle;

    private ActionBar actionBar;
    private boolean isLocalPlaylist;

    private int mStatusSize;

    private String albumPath, playlistName, playlistDetail;

    Context mContext;
    ArrayList<SongBean> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ButterKnife.bind(this);
        mContext  = this;
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
        mlist = new ArrayList<>();


        String playlistid = getIntent().getStringExtra("playlistid");
        final String playlistcount = getIntent().getStringExtra("playlistcount");
        DownLoadData.LoadGeDanDetail(mContext, playlistid, new OkHttpUtils.OnCompleteListener<GeDanDetailBean>() {
            @Override
            public void onSuccess(GeDanDetailBean result) {
                if(result!=null){
                    //设置图片
                    Glide.with(mContext).load(result.getPic_300()).into(ivItemPic);
                    //设置收听量
                    int count = Integer.parseInt(playlistcount);
                    if (count > 10000) {
                        count = count / 10000;
                        ivItemCount.setText(" " + count + "万");
                    } else {
                        ivItemCount.setText(" " + playlistcount);
                    }
                    //设置title
                    mTitle.setText(result.getTitle());
                }
                for (SongBean sb : result.getContent()) {
                }
            }

            @Override
            public void onError(String error) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.playlit_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
