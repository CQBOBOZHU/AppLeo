package com.leoyou.appleo.ui.fragment.douban;

import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.HttpUtil;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanModel implements DoubanController.IDoubanModel {
    CallBack callBack;

    public DoubanModel(CallBack callback) {
        this.callBack = callback;
    }

    @Override
    public void loadData(int start, int count) {
        HttpUtil.getDoubanMovie(start, count, callBack);
    }

    @Override
    public void loadMoreData(int start, int count) {
        HttpUtil.getDoubanMovie(start, count, callBack);
    }
}
