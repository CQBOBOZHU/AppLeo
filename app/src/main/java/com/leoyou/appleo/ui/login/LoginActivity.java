package com.leoyou.appleo.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseActivity;

/**
 * Created by Administrator on 2017/4/20.
 */

public class LoginActivity extends BaseActivity< ILoginView,LoginPresenter> implements ILoginView {
    private TextInputLayout account_tvLy;
    private TextInputLayout password_tvLy;
    private EditText account_edt;
    private EditText password_edt;

    public LoginActivity() {
    }

    @Override
    protected int getToobarId() {
        return R.layout.toolbar;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        account_tvLy = getView(R.id.account_tvLy);
        password_tvLy = getView(R.id.password_tvLy);
        account_edt = account_tvLy.getEditText();
        password_edt = password_tvLy.getEditText();
        account_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 5) {
                    account_tvLy.setError("用户名不能小于6位");
                } else {
                    account_tvLy.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 5 || s.length() > 15) {
                    password_tvLy.setError("密码长度在6到15之间");
                } else {
                    password_tvLy.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void showHint(Object obj) {
        Toast.makeText(this, obj.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setResultFinish(int result) {
        setResult(result);
        finish();
    }

    public void onLogin(View view) {
        mPresenter.login(account_edt.getText().toString(), password_edt.getText().toString());
    }

    @Override
    public Context getContext() {
        return null;
    }
}
