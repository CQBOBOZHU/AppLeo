package com.leoyou.appleo.ui.fragment.index;

import com.leoyou.appleo.base.BaseView;
import com.leoyou.appleo.bean.FuliBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface IIndexView extends BaseView {

    void setData(List<FuliBean.ResultsBean> mRbs);
    void showHint(Object o);
    void showloadErrorView();
    void showEmptyView();
    void showContentView();
    void showNetErrorView();
    void setLoading(boolean isloading);
}
