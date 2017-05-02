package com.leoyou.appleo.ui.login;

import com.leoyou.appleo.net.loginCallBack;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by Administrator on 2017/4/20.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void login(String account, String password, final loginCallBack loginCallBack) {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("我去做somethings");
            }
        });

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            //观察者接收到通知,进行相关操作
            public void onNext(String aLong) {
                System.out.println("我接收到数据了");
                loginCallBack.onSuccess("onSuccess","我接收到数据了");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }
}
