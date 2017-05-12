package com.leoyou.appleo.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/2.
 */

public class RetroFitUtil {

    public  static String yunruiBaseUrl = "http://192.168.99.139:8080/";
    private static String baseUrl = "http://gank.io/";
    public static String API_DOUBAN = "https://api.douban.com";
    private static Retrofit retrofit;

    public static Retrofit getRetorfit() {
        if (retrofit == null)
            retrofit = creatService();
        return retrofit;
    }

    public static Retrofit creatService() {
        return creatService(baseUrl);
    }


    public static Retrofit creatService(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Observable initObservable(Observable api) {
        return api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public  static void subScribe(Observable observable, final CallBack callBack) {

        observable.subscribe(new Subscriber() {
            @Override
            public void onCompleted() {
                callBack.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e);
            }

            @Override
            public void onNext(Object o) {
                callBack.onSuccess(o);
            }
        });
    }
}
