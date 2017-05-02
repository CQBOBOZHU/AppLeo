package com.leoyou.appleo.net;

/**
 * Created by Administrator on 2017/5/2.
 */

public interface loginCallBack {

    void onSuccess(String result,Object data);
    void onFail(Exception e);
}
