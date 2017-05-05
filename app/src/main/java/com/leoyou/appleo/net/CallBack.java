package com.leoyou.appleo.net;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface CallBack<T> {

    void onSuccess(T o);

    void onError(Throwable e);

    void onCompleted();

}
