package com.leoyou.appleo.base;


import android.os.Bundle;
import android.webkit.WebView;

import com.leoyou.appleo.R;

/**
 * Created by Administrator on 2017/5/5.
 */

public abstract class BaseWebActivity extends BaseActivity {
    WebView baseWebView;

    @Override
    protected BaseView getIView() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_web;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        baseWebView = (WebView) getView(R.id.base_webview);
    }

    /**
     * 对webview的属性设置
     */
    public void initWebView() {

    }
}
