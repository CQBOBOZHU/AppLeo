package com.leoyou.appleo.ui.fragment.index;

import android.util.Log;

import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.util.ExceptionUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class IndexPresenter implements IIndexPresenter, CallBack {
    IIndexView iIndexView;
    IIndexModel iIndexModel;

    public IndexPresenter(IIndexView indexView) {
        this.iIndexView = indexView;
        this.iIndexModel = new IndexModel(this);
    }

    @Override
    public void initData(String type, int num, int page) {
        iIndexModel.initData(type, num, page);
    }

    @Override
    public void onSuccess(Object o) {
        iIndexView.setLoading(false);
        iIndexView.setData((List<FuliBean.ResultsBean>) o);
    }

    @Override
    public void onError(Throwable e) {
        iIndexView.setLoading(false);
        Log.v("onError", e.getMessage() == null ? "" : e.getMessage());
        if (ExceptionUtil.getExceptionCode(e) == ExceptionUtil.NET_ERROE) {
            iIndexView.showNetErrorView();
        } else
            iIndexView.showloadErrorView();
    }

    @Override
    public void onCompleted() {
        iIndexView.setLoading(false);
    }

}
