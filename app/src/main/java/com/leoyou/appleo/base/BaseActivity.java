package com.leoyou.appleo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2017/4/20.
 */

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity {
    public P mPresenter;
    public V mBaseView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBaseView = getIView();
        mPresenter = getPresenter();
        initView(savedInstanceState);
    }


    protected abstract V getIView();

    protected abstract int getLayoutId();

    public abstract P getPresenter();

    protected abstract void initView(Bundle savedInstanceState);

    public  <T extends View> T getView(int viewId){

        return (T) findViewById(viewId);
    }
}
