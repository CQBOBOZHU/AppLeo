package com.leoyou.appleo.ui.fragment.book;

import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.net.ApiService;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.RetroFitUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookPresenter extends BasePresenterImpl<BookController.IBookView> implements BookController.IBookPresenter {
    int start = 0;
    int count = 9;
    String tag = "文学";


    @Override
    public void attachView(BookController.IBookView view) {
        super.attachView(view);
    }

    ApiService apiService;

    @Override
    public void loadData() {
        start = 0;
        getApiService().getDoubanBook(tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(bookBean -> bookBean.getBooks())
                .subscribe(new CallBack<List<BookBean.BooksBean>>(mDisposables) {
                    @Override
                    protected void onFail(int code) {
                        mView.stopRefresh(false);
                        onViewFail(code);
                    }

                    @Override
                    public void onNext(@NonNull List<BookBean.BooksBean> booksBeen) {
                        mView.stopRefresh(true);
                        if (booksBeen.size() == 0) {
                            mView.showEmptyView();
                        } else {
                            mView.showContentView();
                            mView.setNewData(booksBeen);
                        }

                    }
                });
    }

    public ApiService getApiService() {
        if (apiService == null)
            apiService = RetroFitUtil.creatService(RetroFitUtil.API_DOUBAN).create(ApiService.class);
        return apiService;
    }


    @Override
    public void loadMoreData() {
        start=start+count;
        getApiService().getDoubanBook(tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(bookBean -> bookBean.getBooks())
                .subscribe(new CallBack<List<BookBean.BooksBean>>(mDisposables) {
                    @Override
                    protected void onFail(int code) {
                        mView.stopLoadMore(false);
                        onViewFail(code);
                    }

                    @Override
                    public void onNext(@NonNull List<BookBean.BooksBean> booksBeen) {
                        mView.stopLoadMore(true);
                        if (booksBeen.size() == 0) {
                            mView.showEmptyView();
                        } else {
                            mView.showContentView();
                            mView.addData(booksBeen);
                        }

                    }
                });
    }
}
