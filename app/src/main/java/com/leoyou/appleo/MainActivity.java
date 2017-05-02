package com.leoyou.appleo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.leoyou.appleo.bean.OrderBean;
import com.leoyou.appleo.net.Api;
import com.leoyou.appleo.net.RetroFitUtil;
import com.leoyou.appleo.ui.index.IndexActivity;
import com.leoyou.appleo.ui.login.LoginActivity;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onIndex(View view) {
        Intent mIntent = new Intent(this, IndexActivity.class);
        startActivity(mIntent);
    }

    public void onLogin(View view) {
        Intent mIntent = new Intent(this, LoginActivity.class);
        startActivity(mIntent);
    }

    public void getOrderList(View view) {
        Api api = RetroFitUtil.instance1().create(Api.class);
        Observable<OrderBean> obser = api.getOrderList("5", "ebaf2b6788ab434dbb09c13071e1b4b8", "0", 1, 1);
        obser.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<OrderBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.v("this", "");
            }

            @Override
            public void onNext(OrderBean orderBean) {
                Log.v("this", "onNext");
            }

        });
    }
}
