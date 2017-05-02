package com.leoyou.appleo.ui.login;

import com.leoyou.appleo.base.BaseModel;
import com.leoyou.appleo.net.loginCallBack;

/**
 * Created by Administrator on 2017/4/20.
 */

public interface ILoginModel extends BaseModel {
    void login(String account,String password,loginCallBack loginCallBack);
}
