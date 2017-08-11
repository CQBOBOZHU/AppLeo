package com.leoyou.appleo.ui.query;

import com.leoyou.appleo.base.BasePresenter;
import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.QueryBean;

import java.util.List;

/**
 * Created by BoBoZhu on 2017/7/21.
 */

public class QueryController {

    interface View extends BaseView {
        void setNewData(List<QueryBean.ResultsBean> mData);

        void addData(List<QueryBean.ResultsBean> mData);

        void stopRefresh();

        void LoadComptle();

        void loadFail();

        void loadEnd();

    }

    interface Presenter extends BasePresenter<View> {
        void getQuery(String type, int count, int page);

        void loadQuery(String type, int count, int page);
    }
}
