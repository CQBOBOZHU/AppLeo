package com.leoyou.appleo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leoyou.appleo.base.BaseModel;
import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BaseView;

/**
 * Created by Administrator on 2017/5/2.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter> extends Fragment implements BaseView {
  public   P mPresenter;
    public  V mView;
    private View baseView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = LayoutInflater.from(getActivity()).inflate(getLayout(), null);
        mView = (V) this;
        mPresenter = getPresenter();
        initView();
        return baseView;
    }

    protected abstract int getLayout();

    protected abstract P getPresenter();

    protected abstract void initView();

    public <T extends View> T getView(int viewId) {
        return (T) baseView.findViewById(viewId);
    }
}
