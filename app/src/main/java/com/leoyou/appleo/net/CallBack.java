package com.leoyou.appleo.net;

import com.leoyou.appleo.util.ExceptionUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/5/2.
 */

public abstract class CallBack<T> implements Observer<T> {

    List<Disposable> mDisposables;

    public CallBack(List<Disposable> mDisposables) {
        this.mDisposables = mDisposables;
    }

    public void onSubscribe(@NonNull Disposable d) {
        mDisposables.add(d);
    }


    public void onError(Throwable e) {
        int code = ExceptionUtil.getExceptionCode(e);
        onFail(code);
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onFail(int code);


}
