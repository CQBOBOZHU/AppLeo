package com.leoyou.appleo.ui.fragment.douban;

import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.net.CallBack;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanPresenter implements DoubanContract.IDoubanPresenter, CallBack<DoubanMovieBean> {
    DoubanContract.IDoubanView iBaseView;
    DoubanContract.IDoubanModel iDoubanModel;

    public DoubanPresenter(DoubanContract.IDoubanView iBaseView) {
        this.iBaseView = iBaseView;
        iDoubanModel = new DoubanModel(this);
    }

    @Override
    public void onSuccess(DoubanMovieBean o) {
        iBaseView.setData(o);
    }

    @Override
    public void onError(Throwable e) {
        iBaseView.showHint("网络错误");
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onrefresh() {
        iDoubanModel.loadData(0, 10);
    }

    @Override
    public void onLoadMore() {

    }
}
