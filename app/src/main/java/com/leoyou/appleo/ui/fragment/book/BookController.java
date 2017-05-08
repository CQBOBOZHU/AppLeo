package com.leoyou.appleo.ui.fragment.book;

import com.leoyou.appleo.base.BaseModel;
import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.net.CallBack;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookController {

    interface IBookView extends BaseView {

        void showHint(String msg);

        void loading();

        void loadMore();

        void setNewData(BookBean t);

        void addData(BookBean t);

        void  showBaseView(int code);

        void stopRefresh(boolean isSuccess);
        void stopLoadMore(boolean isSuccess);
    }

    interface IBookModel extends BaseModel {
        void loadData(String tag, int start, int count, CallBack<BookBean> callBack);

    }

    interface IBookPresenter extends BasePresenter {
        void loadData();

        void loadMoreData();
    }
}
