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
    int start = 1;
    int count = 10;
    String tag = "文学";
    Disposable loadDisposable;


    @Override
    public void attachView(BookController.IBookView view) {
        super.attachView(view);
    }

    @Override
    public void loadData() {
        start = 1;
        ApiService apiService = RetroFitUtil.getRetorfit().create(ApiService.class);
        apiService.getDoubanBook(tag, start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<BookBean, ObservableSource<List<BookBean.BooksBean>>>() {
                    @Override
                    public ObservableSource<List<BookBean.BooksBean>> apply(@NonNull BookBean bookBean) throws Exception {
                        return (ObservableSource<List<BookBean.BooksBean>>) bookBean.getBooks();
                    }
                })
                .doOnNext(new Consumer<List<BookBean.BooksBean>>() {
                    @Override
                    public void accept(@NonNull List<BookBean.BooksBean> booksBeen) throws Exception {
                        if (booksBeen.size()==0){
                            mView.showEmptyView();
                        }
                    }
                })
                .subscribe(new Observer<List<BookBean.BooksBean>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                loadDisposable = d;
            }

            @Override
            public void onNext(@NonNull List<BookBean.BooksBean> booksBeen) {
                mView.setNewData(booksBeen);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void loadMoreData() {
//        bookModel.loadData(tag, start++ * count + 1, count, this);
    }


    @Override
    public void detachView() {
        if (loadDisposable != null && !loadDisposable.isDisposed())
            loadDisposable.dispose();
    }
}
