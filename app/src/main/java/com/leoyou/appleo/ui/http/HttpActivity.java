package com.leoyou.appleo.ui.http;

import android.os.Bundle;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseActivity;

/**
 * Created by BoBoZhu on 2017/8/11.
 */

public class HttpActivity extends BaseActivity<HttpController.View,HttpPresenter> {
    @Override
    protected int getToobarId() {
        return R.layout.toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_http;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
