package com.leoyou.appleo.ui.fragment.index;

import com.leoyou.appleo.base.BasePresenter;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface IIndexPresenter extends BasePresenter<IIndexView> {
    void initData(String type, int num, int page);
}
