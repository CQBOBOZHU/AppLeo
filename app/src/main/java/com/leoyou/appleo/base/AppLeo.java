package com.leoyou.appleo.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/5/2.
 */

public class AppLeo extends Application {
    public  static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
}
