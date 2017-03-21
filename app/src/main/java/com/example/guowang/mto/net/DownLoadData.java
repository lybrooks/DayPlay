package com.example.guowang.mto.net;

import android.content.Context;

import com.example.guowang.mto.bean.GeDanBean;
import com.example.guowang.mto.bean.GeDanDetailBean;
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
}
