package com.example.guowang.mto.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.GeDanListAdapter;
import com.example.guowang.mto.bean.GeDanDetailBean;
import com.example.guowang.mto.bean.SongBean;
import com.example.guowang.mto.manager.MyLinearLayoutManager;
import com.example.guowang.mto.net.DownLoadData;
import com.example.guowang.mto.utils.ColorCaptureUtil;
import com.example.guowang.mto.utils.CommonUtils;
import com.example.guowang.mto.utils.ImageUtils;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.attr.width;

public class PlaylistActicity extends BaseActivity {

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


    private String albumPath, playlistName, playlistDetail;

    Context mContext;
    ArrayList<SongBean> mlist;
    GeDanListAdapter mAdapter;
    ScrollView mScrollView;
    LinearLayout ml;
    ImageView mImageView;

    private int height;
    private String Name;
    private String tag;
    private String desc;
    private int scrool;

    ProgressBar mProgressBar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ButterKnife.bind(this);
        mContext = this;
        initView();
        setListener();
        initColor();

    }

    private int mFlexibleSpaceImageHeight;
    private int mActionBarSize;
    private int mStatusSize;

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setListener() {

        mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, final int scrollY, int oldScrollX, int oldScrollY) {
                float a = (float) scrollY / (mFlexibleSpaceImageHeight - mActionBarSize - mStatusSize);
                if (scrollY > 0 && scrollY < mFlexibleSpaceImageHeight - mActionBarSize - mStatusSize) {
                    actionBar.setTitle(Name);
                    actionBar.setSubtitle(desc);

                }
                if (scrollY == 0) {
                    actionBar.setTitle("歌单");
                    actionBar.setSubtitle(tag);
                }

                mToolbar.setAlpha(1f-(1f-a)+0.35f);

                L.e("scrollY=" + scrollY);
                L.e("mFlexibleSpaceImageHeight=" + mFlexibleSpaceImageHeight);
                L.e("a="+a);

            }
        });

    }


    private void initView() {
        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mActionBarSize = CommonUtils.getActionBarHeight(this);
        mStatusSize = CommonUtils.getStatusHeight(this);
        mImageView = (ImageView) findViewById(R.id.album_art);
        mScrollView = (ScrollView) findViewById(R.id.slv);
        mProgressBar = (ProgressBar) findViewById(R.id.song_progress_normal);

        ml = (LinearLayout) findViewById(R.id.LL_m);
        height = ml.getHeight();
        mlist = new ArrayList<>();
        Long playlistid = Long.valueOf(getIntent().getStringExtra("playlistid"));
        final String playlistcount = getIntent().getStringExtra("playlistcount");
        LoadData(String.valueOf(playlistid), playlistcount);
        initToolBar();
        manager = new MyLinearLayoutManager(this);
        mAdapter = new GeDanListAdapter(this,mlist,playlistid);
        mrlv.setLayoutManager(manager);
        mrlv.setAdapter(mAdapter);


    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.actionbar_back);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("歌单");
        desc = getIntent().getStringExtra("playlistDetail");
        mToolbar.setPadding(0, mStatusSize, 0, 0);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if (!isLocalPlaylist) {
            mToolbar.setSubtitle(desc);
        }


    }

    private void initColor() {
        final Handler mhandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == ColorCaptureUtil.SUCCESS) {
                    ArrayList<Integer> colors = (ArrayList<Integer>) msg.obj;
                    L.e("stop");
                    mImageView.setBackgroundColor(colors.get(colors.size() - 1));
                    mToolbar.setBackgroundColor(colors.get(colors.size() - 1));
                }
            }
        };
        final String albumart = getIntent().getStringExtra("albumart");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    L.e("start");
                    SystemClock.currentThreadTimeMillis();
                    Bitmap bitmap = Glide.with(mContext)
                            .load(albumart)
                            .asBitmap()
                            .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .get();
                    ColorCaptureUtil utils = new ColorCaptureUtil(mhandler);
                    utils.getBitmapColors(bitmap);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }).start();
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
                    desc = result.getDesc();
                    tag = result.getTag();
                    Name = result.getTitle();
                    mTitle.setText(result.getTitle());
                }
                mAdapter.update(result.getContent());

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
