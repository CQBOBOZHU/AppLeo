package com.leoyou.appleo.ui.fragment.book;

import android.util.Log;

import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.HttpUtil;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookModel implements BookController.IBookModel {
    @Override
    public void loadData(String tag, int start, int count, CallBack<BookBean> callBack) {
        Log.v("this", "start:" + start + "count:" + count);
        HttpUtil.getDoubanBook(tag, start, count, callBack);
    }
}
