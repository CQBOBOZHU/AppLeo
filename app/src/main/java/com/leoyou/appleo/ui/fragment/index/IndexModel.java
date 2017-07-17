package com.leoyou.appleo.ui.fragment.index;


import com.leoyou.appleo.net.CallBack;


/**
 * Created by Administrator on 2017/5/2.
 */

public class IndexModel  implements IIndexModel {
    CallBack callBack;

    public IndexModel(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void initData(String type, int num, int page) {
    }
}
