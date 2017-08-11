package com.leoyou.appleo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017/4/20.
 */

public interface BaseView {

    Context getContext();

//    void showViewByPosition(int position);

    /**
     * 加载activity
     * @param cls
     * @param bundle
     */
    void startActivity(Class cls, Bundle bundle);

    /**
     * 加载activity
     * @param cls
     * @param bundle
     * @param requestCode
     */
    void startActivityForResult(Class cls, Bundle bundle, int requestCode);

    /**
     * 加载多个activity
     * @param bundle
     * @param classes
     */
    void startMoreActivity(Bundle bundle,Class ...classes);

    /**
     * 现在加载中的dialog
     */
    void showLoadingDialog();

    /**
     * 关闭dialog
     */
    void stopLoadingDialog();

    /**
     * 加载布局
     */
    void showLoadingView();

    /**
     * 加载错误布局
     */
    void showLoadErrorView();

    /**
     * 网络错误布局
     */
    void showNetErrorView();

    /**
     * 内容布局
     */
    void showContentView();
    /**
     * 空布局
     */
    void showEmptyView();


    /**
     * 提示消息
     * @param msg
     */
    void showMessage(String msg);

    /**
     * 关闭activity
     */
    void closeActivity();

    /**
     * 关闭activity
     * @param resultCode
     */
    void closeActivity(int resultCode);

    /**
     * 注销账户
     */
    void logOffUserInfo();

    /**
     * 设置view的visible
     * @param visible
     */
    void setViewVisible(int visible);

    /**
     * 显示toast
     * @param message
     */
    void  showToastMessage(@NonNull String message);

    /**
     * 长时间显示toast
     * @param message
     */
    void  showToastLongMessage(@NonNull String message);
}
