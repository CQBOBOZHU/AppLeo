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

    @Override
    public void loadData(String type) {
        loadData(type, 100, 1);
    }

    @Override
    public void loadData(String type, int count, int page) {
        RetroFitUtil.getRetorfit()
                .create(ApiService.class)
                .getFuli(type, count, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(fuliBean -> fuliBean.getResults())
                .subscribe(new CallBack<List<FuliBean.ResultsBean>>(mDisposables) {
                    @Override
                    protected void onFail(int code,String  msg) {
                        onViewFail(code);
                    }

                    @Override
                    public void onNext(@NonNull List<FuliBean.ResultsBean> resultsBeen) {
                        if (resultsBeen.size() == 0) {
                            mView.showEmptyView();
                        } else {
                            mView.showContentView();
                            mView.setData(resultsBeen);
                        }
                    }
                });
    }
}
