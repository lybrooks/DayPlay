package com.example.guowang.mto.utils;

import android.util.Log;
/**   
 * All rights Reserved, Designed By www.tydic.com
 * @ClassName:  L   
 * @Description:
 * @author: guowang 
 * @date:   2017/3/16 15:22
 */

public class L {
    public static boolean isDebug = true;
    private static final String TAG = "MTO";

    public static void i(String msg){
        if(isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String msg){
        if(isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String msg){
        if(isDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void v(String msg){
        if(isDebug) {
            Log.v(TAG, msg);
        }
    }

    public static void i(String tag, String msg){
        if(isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if(isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if(isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg){
        if(isDebug) {
            Log.v(tag, msg);
        }
    }
}
