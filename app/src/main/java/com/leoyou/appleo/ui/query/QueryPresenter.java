package com.leoyou.appleo.ui.query;


import com.leoyou.appleo.base.BasePresenterImpl;
import com.leoyou.appleo.bean.QueryBean;
import com.leoyou.appleo.net.ApiService;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.RetroFitUtil;

import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BoBoZhu on 2017/7/21.
 */

public class QueryPresenter extends BasePresenterImpl<QueryController.View> implements QueryController.Presenter {
    ApiService apiService;

    @Override
    public void getQuery(String type, int pageSize, int page) {
        request(type, pageSize, page, new CallBack<List<QueryBean.ResultsBean>>(mDisposables) {

                    @Override
                    public void onNext(@NonNull List<QueryBean.ResultsBean> resultsBeen) {
                        mView.setNewData(resultsBeen);
                        mView.stopRefresh();
                    }

                    @Override
                    protected void onFail(int code,String  msg) {
                        mView.stopRefresh();
                        mView.showToastMessage(msg);
                    }
                }
        );
    }


    @Override
    public void loadQuery(String type, int pageSize, int page) {
        request(type, pageSize, page, new CallBack<List<QueryBean.ResultsBean>>(mDisposables) {

                    @Override
                    public void onNext(@NonNull List<QueryBean.ResultsBean> resultsBeen) {
                        if (resultsBeen.size() < pageSize) {
                            mView.LoadComptle();
                        } else
                            mView.loadEnd();
                        mView.addData(resultsBeen);
                    }

                    @Override
                    protected void onFail(int code,String  msg) {
                        mView.loadFail();
                        mView.showToastMessage(msg);
                    }
                }
        );
    }

    private void request(String type, int pageSize, int page, Observer callback) {
        if (apiService == null)
            apiService = RetroFitUtil.getRetorfit().create(ApiService.class);
        apiService.getQueryList(type, pageSize, page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<QueryBean, List<QueryBean.ResultsBean>>() {


                    @Override
                    public List<QueryBean.ResultsBean> apply(@NonNull QueryBean queryBean) throws Exception {
                        if (queryBean.isError()) {
                            throw new RuntimeException("加载失败");
                        }
                        return queryBean.getResults();
                    }
                })
                .subscribe(callback);
    }
}
