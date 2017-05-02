package com.leoyou.appleo.ui.fragment.index;

import android.util.Log;

import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.net.Api;
import com.leoyou.appleo.net.CallBack;

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

public class IndexModel implements IIndexModel {
    CallBack callBack;

    public IndexModel(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void initData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://gank.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Observable<FuliBean> apiFuli = api.getFuli("福利", 50, 1);
        apiFuli.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FuliBean>() {
                    @Override
                    public void onCompleted() {
                        callBack.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e);
                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        callBack.onSuccess(fuliBean.getResults());
                    }
                });
    }
}