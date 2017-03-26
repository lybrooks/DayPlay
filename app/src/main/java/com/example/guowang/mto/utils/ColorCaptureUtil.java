package com.example.guowang.mto.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class ColorCaptureUtil {
    private static final String TAG = "ColorCaptureUtil";
    private Handler mHandler;
    public static final int SUCCESS = 1;

    public ColorCaptureUtil(Handler handler) {
        mHandler = handler;
    }


    public void getBitmapColors(Bitmap bitmap) {
        getBitmapColors(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }


    public void getBitmapColors(Bitmap bitmap, int fromX, int fromY, int toX, int
            toY) {
        new Thread(new MyRunnable(bitmap, fromX, fromY, toX, toY, mHandler)).start();
    }

    private class MyRunnable implements Runnable {
        private Bitmap bitmap;
        private int fromX, fromY, toX, toY;
        private Handler mHandler;

        public MyRunnable(Bitmap bitmap, int fromX, int fromY, int toX, int toY, Handler handler) {
            this.bitmap = bitmap;
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
            this.mHandler = handler;
        }

        @Override
        public void run() {
            int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
            HashMap<Integer, Integer> colors = new HashMap<>();
            TreeMap<Integer, Integer> sortedColors = new TreeMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            bitmap.getPixels(pixels, 0, bitmap.getWidth(), fromX, fromY, toX - fromX, toY - fromY);
            for (int i = 0; i < pixels.length / 15000; i++) {
                int pixel = pixels[i];
                Integer num = colors.get(pixel);
                if (num == null) {
                    colors.put(pixel, 1);
                } else {
                    num += 1;
                    colors.put(pixel, num);
                }
            }
            for (Map.Entry<Integer, Integer> entry : colors.entrySet()) {
                sortedColors.put(entry.getValue(), entry.getKey());
            }
            for (Map.Entry<Integer, Integer> entry : sortedColors.entrySet()) {
                result.add(entry.getValue());
                Log.d(TAG, "run: color:" + entry.getValue() + ",count:" + entry.getKey());
            }
            Message msg = new Message();
            msg.obj = result;
            msg.what = SUCCESS;
            mHandler.sendMessage(msg);
        }
    }

}
