package com.example.guowang.mto.fragment;


import android.content.Context;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.GeDanRlvAdapter;
import com.example.guowang.mto.bean.GeDanBean;
import com.example.guowang.mto.bean.GeDanDetailBean;
import com.example.guowang.mto.bean.GedanInfoBean;
import com.example.guowang.mto.net.DownLoadData;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MusicsFragment extends Fragment {


    @Bind(R.id.rlv_musics)
    RecyclerView mRlvMusics;

    GeDanRlvAdapter mGedanAdapter;
    private ArrayList<GedanInfoBean> mGeDanlist;
    Context mContext;
    int mNewState;
    GridLayoutManager manager;

    final static int ActionDownLoad = 1;
    int Pagesize = 5;

    public MusicsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_musics, container, false);
        ButterKnife.bind(this, view);
        iniView();
        setListener();
        return view;
    }

    private void setListener() {
        mRlvMusics.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mNewState = newState;
                lastPosition = manager.findLastVisibleItemPosition();
                if (lastPosition >= mGedanAdapter.getItemCount() - 1
                        && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Pagesize++;
                    LoadData(ActionDownLoad, Pagesize);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }

    private void iniView() {
        mGeDanlist = new ArrayList<>();
        mContext = getContext();
        mGedanAdapter = new GeDanRlvAdapter(mContext, mGeDanlist);
        manager = new GridLayoutManager(mContext, 2);
        //当加载数据的时候，foot这是为占两列
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == mGedanAdapter.getItemCount() - 1 ? 2 : 1;
            }
        });
        mRlvMusics.setLayoutManager(manager);
        mRlvMusics.setAdapter(mGedanAdapter);
        LoadData(ActionDownLoad, Pagesize);

    }

    private void LoadData(final int action, int Pagesize) {
        DownLoadData.LoadGeDan(mContext, Pagesize, new OkHttpUtils.OnCompleteListener<GeDanBean>() {
            @Override
            public void onSuccess(GeDanBean result) {
                if (result != null && result.getContent() != null) {
                    List<GedanInfoBean> list = result.getContent();
                    switch (action) {
                        case ActionDownLoad:
                            mGedanAdapter.upadte(list);
                            break;
                    }
                }
            }
            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
