package com.leoyou.appleo.ui.fragment.index;

import android.util.Log;

import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.net.ApiService;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.RetroFitUtil;
import com.leoyou.appleo.util.ExceptionUtil;
import com.leoyou.appleo.util.LogUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/2.
 */

public class IndexPresenter extends BasePresenterImpl<IIndexView> implements IIndexPresenter {


    @Override
    public void attachView(IIndexView view) {
        super.attachView(view);
    }
    Disposable disposable;
    @Override
    public void loadFuli() {
        Observable<FuliBean> observable = RetroFitUtil.getRetorfit().create(ApiService.class)
                .getFuli("福利", 10, 1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(fuliBean -> {
                    LogUtil.v( "map"+Thread.currentThread().getName());
                    return  fuliBean.getResults();
                })
                .doOnNext(resultsBeen -> {
                    if (resultsBeen.size() == 0) {
                        LogUtil.v( Thread.currentThread().getName());
                        mView.showEmptyView();
                    }
                })
                .subscribe(new Observer<List<FuliBean.ResultsBean>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtil.v("onSubscribe"+Thread.currentThread().getName());
                disposable=d;
            }

            @Override
            public void onNext(@NonNull List<FuliBean.ResultsBean> resultsBeen) {
                LogUtil.v("onNext"+   Thread.currentThread().getName());

                mView.setData(resultsBeen);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.v("onError"+Thread.currentThread().getName());
                mView.showLoadErrorView();
            }

            @Override
            public void onComplete() {
                LogUtil.v("onComplete");
            }
        });

    }


}
