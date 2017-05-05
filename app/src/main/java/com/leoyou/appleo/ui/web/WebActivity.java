package com.leoyou.appleo.ui.web;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseWebActivity;

/**
 * Created by Administrator on 2017/5/5.
 */

public class WebActivity extends BaseWebActivity {

    @Override
    protected int getToobarId() {
        return R.layout.toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        String url=getIntent().getStringExtra("webUrl");
        WebView webView= (WebView) getView(R.id.webview);
        webView.loadUrl(url);
    }
}
