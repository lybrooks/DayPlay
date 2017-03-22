package com.example.guowang.mto.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.GeDanListAdapter;
import com.example.guowang.mto.bean.GeDanDetailBean;
import com.example.guowang.mto.bean.SongBean;
import com.example.guowang.mto.manager.MyLinearLayoutManager;
import com.example.guowang.mto.net.DownLoadData;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

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
    @Bind(R.id.rlv_music)
    RecyclerView mrlv;


    private ActionBar actionBar;
    MyLinearLayoutManager manager;
    private boolean isLocalPlaylist;

    private int mStatusSize;

    private String albumPath, playlistName, playlistDetail;

    Context mContext;
    ArrayList<SongBean> mlist;
    GeDanListAdapter mAdapter;
    ScrollView mScrollView;
    LinearLayout ml;

    int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ButterKnife.bind(this);
        mContext = this;
        initView();
        setListener();
    }

    private void setListener() {

        mrlv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int scrollY = mScrollView.getScrollY();
                if (mScrollView.getScrollY() <= ml.getHeight()) {
                    L.e("height=" + ml.getHeight() + ",scrollY="+scrollY);
                    return false;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
      /*  int scrollY = mScrollView.getScrollY();
        L.e("height=" + height + ",scrollY="+scrollY);
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                scrollY = mScrollView.getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                scrollY = mScrollView.getScrollY();
                break;
        }*/
        return super.onTouchEvent(event);
    }

    private void initView() {
        mScrollView = (ScrollView) findViewById(R.id.slv);
        ml = (LinearLayout) findViewById(R.id.LL_m);
        height = ml.getHeight();
        initToolBar();
        mlist = new ArrayList<>();
        String playlistid = getIntent().getStringExtra("playlistid");
        final String playlistcount = getIntent().getStringExtra("playlistcount");
        LoadData(playlistid, playlistcount);
        manager = new MyLinearLayoutManager(this);
        mAdapter = new GeDanListAdapter(this, mlist);
        mrlv.setLayoutManager(manager);
        mrlv.setAdapter(mAdapter);


    }

    private void initToolBar() {
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

    private void LoadData(String playlistid, final String playlistcount) {
        DownLoadData.LoadGeDanDetail(mContext, playlistid, new OkHttpUtils.OnCompleteListener<GeDanDetailBean>() {
            @Override
            public void onSuccess(GeDanDetailBean result) {
                if (result != null) {
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
                mAdapter.update(result.getContent());

//                for (SongBean sb : result.getContent()) {
//                    ArrayList<SongBean> content = result.getContent();
//                }
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
