package com.leoyou.appleo.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.leoyou.appleo.net.logInterceptor.Level;
import com.leoyou.appleo.net.logInterceptor.LoggingInterceptor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/2.
 */

public class RetroFitUtil {

    public static String yunruiBaseUrl = "http://192.168.99.139:8080/";
    private static String baseUrl = "http://gank.io/";
    public static String API_DOUBAN = "https://api.douban.com";
    private static Retrofit retrofit;


    public static Retrofit getRetorfit() {
        if (retrofit == null) {
            synchronized (RetroFitUtil.class) {
                if (retrofit == null) {
                    retrofit = creatService();
                }
            }
        }
        return retrofit;
    }

    public static Retrofit creatService() {
        return creatService(baseUrl);
    }


    public static Retrofit creatService(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .addInterceptor(new LoggingInterceptor.Builder()
                        .loggable(false)
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .request("Request")
                        .response("Response")
                        .addHeader("Front-end", "android")
                        .build());

        return new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }


}
