package com.leoyou.appleo.ui.fragment.index;

import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.net.CallBack;

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
    public void initData() {
        iIndexModel.initData();
    }

    @Override
    public void onSuccess(Object o) {
        iIndexView.setData((List<FuliBean.ResultsBean>) o);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }

}
