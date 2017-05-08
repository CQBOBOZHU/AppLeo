package com.leoyou.appleo.ui.fragment.book;

import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.net.CallBack;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookPresenter implements BookController.IBookPresenter, CallBack<BookBean> {
    BookController.IBookView baseView;
    BookController.IBookModel bookModel;
    int start = 1;
    int count = 9;
    String tag = "文学";

    public BookPresenter(BookController.IBookView baseView) {
        this.baseView = baseView;
        bookModel = new BookModel();
    }

    @Override
    public void loadData() {
        start=1;
        bookModel.loadData(tag, start, count, this);
    }

    @Override
    public void loadMoreData() {
        bookModel.loadData(tag, start++ * count + 1, count, this);
    }

    @Override
    public void onSuccess(BookBean o) {
        if (start == 1) {
            baseView.showBaseView(1);
            baseView.stopRefresh(true);
            baseView.setNewData(o);
        } else {
            baseView.stopLoadMore(true);
            baseView.addData(o);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (start == 1) {
            baseView.stopRefresh(false);
        } else {
            baseView.stopLoadMore(false);
        }
        baseView.showBaseView(3);
    }

    @Override
    public void onCompleted() {

    }
}
