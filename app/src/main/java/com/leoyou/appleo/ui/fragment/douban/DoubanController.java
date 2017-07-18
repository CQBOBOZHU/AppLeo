package com.leoyou.appleo.ui.fragment.douban;

import com.leoyou.appleo.base.BaseModel;
import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.DoubanMovieBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanController {

    interface IDoubanView extends BaseView {
        void onrefresh();

        void onLoadMore();

        void setData(List<DoubanMovieBean.SubjectsBean> subjectsBeens);

        void addData(List<DoubanMovieBean.SubjectsBean> subjectsBeens);

        void showHint(String msg);

        void showBaseView(int code);
    }


    interface IDoubanPresenter extends BasePresenter<IDoubanView> {
        void onrefresh();

        void onLoadMore();
    }
}
