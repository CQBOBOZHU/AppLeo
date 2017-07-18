package com.leoyou.appleo.base;


import com.leoyou.appleo.util.ExceptionUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    protected V mView;
    public List<Disposable> mDisposables = new ArrayList<>();

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mDisposables.stream().forEach(disposable -> disposable.dispose());
        mView = null;
    }

    public void onViewFail(int code) {
        switch (code) {
            case ExceptionUtil.NET_CONNECT:
            case ExceptionUtil.NET_TIMEOUT:
                mView.showNetErrorView();
                break;
            default:
                mView.showLoadErrorView();
        }
    }

}
