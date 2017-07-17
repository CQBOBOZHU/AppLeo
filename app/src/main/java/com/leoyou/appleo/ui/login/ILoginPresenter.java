package com.leoyou.appleo.ui.login;

import com.leoyou.appleo.base.BasePresenter;

/**
 * Created by Administrator on 2017/4/20.
 */

public interface ILoginPresenter extends BasePresenter<ILoginView> {

    void login(String account,String password);
}
