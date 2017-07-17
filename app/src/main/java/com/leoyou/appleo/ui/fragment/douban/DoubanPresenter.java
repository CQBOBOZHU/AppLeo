package com.leoyou.appleo.ui.fragment.douban;

import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.net.CallBack;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanPresenter extends BasePresenterImpl<DoubanController.IDoubanView> implements DoubanController.IDoubanPresenter {

    @Override
    public void attachView(DoubanController.IDoubanView view) {
        super.attachView(view);
    }

    @Override
    public void onrefresh() {

    }

    @Override
    public void onLoadMore() {

    }

}
