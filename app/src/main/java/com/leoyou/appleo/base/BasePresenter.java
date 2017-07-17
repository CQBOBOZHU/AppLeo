package com.leoyou.appleo.base;

/**
 * Created by Administrator on 2017/4/20.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();


}
