package com.example.guowang.mto.utils;

import android.app.Application;
import android.content.Context;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class MtoAplication extends Application {



    private static MtoAplication instance;
    public static MtoAplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        instance = this;
    }
    public static MtoAplication getInstance() {

        if (instance == null) {
            instance = new MtoAplication();
        }
        return instance;
    }


}
