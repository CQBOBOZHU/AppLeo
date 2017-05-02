package com.leoyou.appleo.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/2.
 */

public class RetroFitUtil {

    static String gankBaseUrl = "http://gank.io";
    static String cgankBaseUrl = "https://api.yr01.net";
    static Retrofit retrofit;
    static Retrofit Cretrofit;

    public static Retrofit instance() {
        synchronized (RetroFitUtil.class) {
            if (retrofit == null)
                retrofit = new Retrofit.Builder()
                        .baseUrl(gankBaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            return retrofit;
        }
    }

    public static Retrofit instance1() {
        synchronized (RetroFitUtil.class) {
            if (Cretrofit == null)
                Cretrofit = new Retrofit.Builder()
                        .baseUrl(cgankBaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            return Cretrofit;
        }
    }
}
