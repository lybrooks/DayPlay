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
import com.example.guowang.mto.bean.GedanInfoBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicsFragment extends Fragment {


    @Bind(R.id.rlv_musics)
    RecyclerView mRlvMusics;

    private ArrayList<GedanInfoBean> mGeDanlist;
    Context mContext;

    public MusicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_musics, container, false);
        ButterKnife.bind(this, view);
        iniView();
        return view;
    }

    private void iniView() {
        mGeDanlist = new ArrayList<>();
        mContext = getContext();

        GeDanRlvAdapter mGedanAdapter = new GeDanRlvAdapter(mContext, mGeDanlist);
        GridLayoutManager manager = new GridLayoutManager(mContext,2);
        mRlvMusics.setLayoutManager(manager);
        mRlvMusics.setAdapter(mGedanAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
