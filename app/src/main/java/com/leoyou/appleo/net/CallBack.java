package com.leoyou.appleo.net;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface CallBack {

    void onSuccess(Object o);

    void onError(Throwable e);

    void onCompleted();

}
