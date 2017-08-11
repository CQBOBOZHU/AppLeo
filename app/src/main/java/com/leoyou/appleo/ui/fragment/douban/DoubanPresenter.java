package com.leoyou.appleo.ui.fragment.douban;

import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.net.ApiService;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.RetroFitUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

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
        RetroFitUtil.creatService(RetroFitUtil.API_DOUBAN)
                .create(ApiService.class)
                .getDoubanMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(doubanMovieBean -> doubanMovieBean.getSubjects())
                .subscribe(new CallBack<List<DoubanMovieBean.SubjectsBean>>(mDisposables) {

                    @Override
                    public void onNext(@NonNull List<DoubanMovieBean.SubjectsBean> subjectsBeens) {
                        if (subjectsBeens.size() == 0) {
                            mView.showEmptyView();
                        } else {
                            mView.showContentView();
                            mView.setData(subjectsBeens);
                        }
                    }

                    @Override
                    protected void onFail(int code, String msg) {
                        onViewFail(code);
                    }
                });
    }

    @Override
    public void onLoadMore() {

    }

}
