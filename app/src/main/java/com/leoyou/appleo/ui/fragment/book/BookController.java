package com.leoyou.appleo.ui.fragment.book;

import com.leoyou.appleo.base.BaseModel;
import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.net.CallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookController {

    interface IBookView extends BaseView {

        void showHint(String msg);

        void loading();

        void loadMore();

        void setNewData(List<BookBean.BooksBean> mData);

        void addData(List<BookBean.BooksBean> mData);

        void  showBaseView(int code);

        void stopRefresh(boolean isSuccess);
        void stopLoadMore(boolean isSuccess);
    }


    interface IBookPresenter extends BasePresenter<IBookView> {
        void loadData();

        void loadMoreData();
    }
}
