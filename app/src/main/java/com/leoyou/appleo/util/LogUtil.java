package com.leoyou.appleo.util;

import android.util.Log;


import java.util.logging.Level;

import okhttp3.internal.platform.Platform;

/**
 * Created by Administrator on 2016/11/25.
 */

public class LogUtil {
    private static String TAG = "app";

    public static void v(Object obj) {
            if (obj == null)
                Log.v(TAG, "null");
            Log.v(TAG, obj.toString());
    }

    public static void e(Object obj) {
            if (obj == null)
                Log.v(TAG, "null");
            Log.e(TAG, obj.toString());
    }

    public static void log(int type, String tag, String msg) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(tag);
        switch (type) {
            case Platform.INFO:
                logger.log(Level.INFO, msg);
                break;
            default:
                logger.log(Level.WARNING, msg);
                break;
        }
    }
}
