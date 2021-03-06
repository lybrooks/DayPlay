package com.example.guowang.mto.net;

import android.content.Context;

import com.example.guowang.mto.bean.GeDanBean;
import com.example.guowang.mto.bean.GeDanDetailBean;
import com.example.guowang.mto.bean.LoopImgBean;
import com.example.guowang.mto.bean.MusicInfoBean;
import com.example.guowang.mto.bean.SongInfoBean;
import com.example.guowang.mto.utils.L;
import com.example.guowang.mto.utils.OkHttpUtils;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class DownLoadData {
    static String BaseUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.6.5.6&format=json";
    static String Method = "method";

    //下载歌单
    public static void LoadGeDan(Context mContext, int pagesize, OkHttpUtils.OnCompleteListener<GeDanBean> listener) {
        OkHttpUtils<GeDanBean> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(BaseUrl)
                .addParam(Method, "baidu.ting.diy.gedan")
                .addParam("page_size", pagesize + "")
                .addParam("age_no", "10")
                .targetClass(GeDanBean.class)
                .execute(listener);
    }

    //下载歌单详情
    public static void LoadGeDanDetail(Context mContext, String listid, OkHttpUtils.OnCompleteListener<GeDanDetailBean> listener) {

        OkHttpUtils<GeDanDetailBean> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(BaseUrl)
                .addParam(Method, "baidu.ting.diy.gedanInfo")
                .addParam("listid", listid)
                .targetClass(GeDanDetailBean.class)
                .execute(listener);
    }

    //加载歌曲信息
    public static void LoadSongInfo(Context mContext, Long SongsId, OkHttpUtils.OnCompleteListener<SongInfoBean> listener) {
        OkHttpUtils<SongInfoBean> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(BMA.Song.songInfo(SongsId))
                .targetClass(SongInfoBean.class)
                .execute(listener);
    }

    //下载图片轮播信息
    public static void LoadLoopImg(Context mContext, int num, OkHttpUtils.OnCompleteListener<LoopImgBean> listener) {
        OkHttpUtils<LoopImgBean> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(BMA.focusPic(num))
                .targetClass(LoopImgBean.class)
                .execute(listener);
    }


}
