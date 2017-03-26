package com.example.guowang.mto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guowang.mto.R;
import com.example.guowang.mto.bean.LoopImgBean;
import com.example.guowang.mto.net.DownLoadData;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;
import com.example.guowang.mto.view.FlowIndicator;
import com.example.guowang.mto.view.SlideAutoLoopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NewMusicFragment extends Fragment {

    SlideAutoLoopView slideAutoLoopView;
    FlowIndicator mflowIndicator;

    String[] imgurl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_music, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        slideAutoLoopView = (SlideAutoLoopView) view.findViewById(R.id.slideAutoLoopView);
        mflowIndicator = (FlowIndicator) view.findViewById(R.id.flowIndicator);
    }


    private void initData() {
        final String imgArr[] = new String[7];
        DownLoadData.LoadLoopImg(getContext(), 7, new OkHttpUtils.OnCompleteListener<LoopImgBean>() {
            @Override
            public void onSuccess(LoopImgBean result) {
                if (result != null) {
                    L.e(result.toString());
                    List<LoopImgBean.PicBean> pic = result.getPic();
                    for (int i = 0; i < pic.size(); i++) {
                        L.e("size=" + pic.size());
                        L.e((String) pic.get(i).getRandpic());
                        String randpic = (String) pic.get(i).getRandpic();
                        imgArr[i] = randpic;
                    }
                    L.e("length=" + imgArr.length);
                    showLoopView(imgArr, imgArr.length);
                }

            }

            @Override
            public void onError(String error) {

            }
        });


    }

    private void showLoopView(String[] imgArr, int length) {
        slideAutoLoopView.startPlayLoop(mflowIndicator, imgArr, length);
    }

    private String[] getUrl(LoopImgBean result) {
        String[] imgurl = new String[]{};
        List<LoopImgBean.PicBean> pic = result.getPic();
        for (int i = 0; i < pic.size(); i++) {
            String randpic = (String) pic.get(i).getRandpic();
            imgurl[i] = randpic;
        }
        L.e(imgurl.toString());
        L.e(imgurl.length + "");
        return imgurl;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
