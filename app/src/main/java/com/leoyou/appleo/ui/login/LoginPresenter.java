package com.leoyou.appleo.ui.login;

import android.text.TextUtils;

import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.net.loginCallBack;


/**
 * Created by Administrator on 2017/4/20.
 */

public class LoginPresenter extends BasePresenterImpl<ILoginView> implements ILoginPresenter  {

    @Override
    public void attachView(ILoginView view) {
        super.attachView(view);
    }

    @Override
    public void login(String account, String password) {
        if (TextUtils.isEmpty(account)){
            mView.showHint("账户不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)){
            mView.showHint("密码不能为空");
            return;
        }
//        loginModel.login(account,password,this);
    }

}
