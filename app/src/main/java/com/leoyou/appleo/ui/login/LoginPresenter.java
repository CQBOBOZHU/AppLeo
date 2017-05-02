package com.leoyou.appleo.ui.login;

import android.text.TextUtils;

import com.leoyou.appleo.net.loginCallBack;


/**
 * Created by Administrator on 2017/4/20.
 */

public class LoginPresenter implements ILoginPresenter , loginCallBack {
    ILoginView loginView;
    LoginModel loginModel;
    public LoginPresenter(ILoginView loginView) {
        this.loginView=loginView;
        loginModel=new LoginModel();
    }

    @Override
    public void login(String account, String password) {
        if (TextUtils.isEmpty(account)){
            loginView.showHint("账户不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)){
            loginView.showHint("密码不能为空");
            return;
        }
        loginModel.login(account,password,this);
    }

    @Override
    public void onSuccess(String result, Object data) {
        loginView.showHint("登录成功");
        loginView.setResultFinish(1);
    }

    @Override
    public void onFail(Exception e) {

    }
}
