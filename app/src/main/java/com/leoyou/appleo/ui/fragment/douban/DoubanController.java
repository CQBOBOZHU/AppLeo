package com.leoyou.appleo.ui.fragment.douban;

import com.leoyou.appleo.base.BaseModel;
import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.DoubanMovieBean;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanController {

    interface IDoubanView extends BaseView {
        void onrefresh();

        void onLoadMore();

        void setData(DoubanMovieBean doubanMovieBean);

        void addData(DoubanMovieBean doubanMovieBean);

        void showHint(String msg);

        void showBaseView(int code);
    }

    interface IDoubanModel extends BaseModel {
        void loadData(int start, int count);

        void loadMoreData(int start, int count);

    }

    interface IDoubanPresenter extends BasePresenter {
        void onrefresh();

        void onLoadMore();
    }
}
