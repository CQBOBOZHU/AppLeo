package com.leoyou.appleo.ui.fragment.index;

import android.util.Log;

import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.net.Api;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.RetroFitUtil;

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
    public void initData(String type, int num, int page) {

        Api api = RetroFitUtil.instance().create(Api.class);
        Observable<FuliBean> apiFuli = api.getFuli(type, num, page);
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
