package com.leoyou.appleo.ui.login;

import com.leoyou.appleo.net.loginCallBack;

/**
 * Created by Administrator on 2017/4/20.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void login(String account, String password, final loginCallBack loginCallBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                loginCallBack.onSuccess("login","onSuccess");
            }
        }).start();
    }
}
