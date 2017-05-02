package com.leoyou.appleo.ui.login;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseActivity;
import com.leoyou.appleo.base.BasePresenter;

/**
 * Created by Administrator on 2017/4/20.
 */

public class LoginActivity extends BaseActivity<LoginPresenter,ILoginView> implements ILoginView{
    @Override
    protected ILoginView getIView() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter(mBaseView);
    }


}
