package com.example.guowang.mto.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.guowang.mto.R;
import com.example.guowang.mto.adapter.GeDanRlvAdapter;
import com.example.guowang.mto.bean.GeDanBean;
import com.example.guowang.mto.bean.GedanInfoBean;
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

    public MusicsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_musics, container, false);
        ButterKnife.bind(this, view);
        iniView();
        return view;
    }

    private void iniView() {
        mGeDanlist = new ArrayList<>();
        mContext = getContext();
        mGedanAdapter = new GeDanRlvAdapter(mContext, mGeDanlist);
        GridLayoutManager manager = new GridLayoutManager(mContext,2);
        //当加载数据的时候，foot这是为占两列
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == mGedanAdapter.getItemCount() - 1 ? 2 : 1;
            }
        });
        mRlvMusics.setLayoutManager(manager);
        mRlvMusics.setAdapter(mGedanAdapter);

        mRlvMusics.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) { 
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        LoadData();

    }

    private void LoadData() {
        OkHttpUtils<GeDanBean> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl("http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.6.5.6&format=json&method=baidu.ting.diy.gedan")
                .addParam("page_size","10")
                .addParam("age_no","10")
                .targetClass(GeDanBean.class)
                .execute(new OkHttpUtils.OnCompleteListener<GeDanBean>() {
                    @Override
                    public void onSuccess(GeDanBean result) {
                        List<GedanInfoBean> list = result.getContent();
                        for (GedanInfoBean bean:list){
                            mGedanAdapter.upadte(list);
                            L.e(bean.toString());
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
