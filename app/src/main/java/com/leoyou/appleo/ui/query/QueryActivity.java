package com.leoyou.appleo.ui.query;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseActivity;
import com.leoyou.appleo.bean.QueryBean;
import com.leoyou.appleo.ui.wight.MyDecoration;

import java.util.List;

/**
 * Created by BoBoZhu on 2017/7/21.
 */

public class QueryActivity extends BaseActivity<QueryController.View, QueryPresenter> implements QueryController.View {

    RecyclerView recyclerView;
    String type = "all";
    int pageSize = 15;
    int page = 1;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected int getToobarId() {
        return R.layout.toolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_query;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MyDecoration(this, LinearLayoutManager.HORIZONTAL));
        baseQuickAdapter = new BaseQuickAdapter<QueryBean.ResultsBean, BaseViewHolder>(R.layout.item_query, null) {

            @Override
            protected void convert(BaseViewHolder helper, QueryBean.ResultsBean item) {
                helper.setText(R.id.item_desc_tv, item.getDesc())
                        .setText(R.id.item_type_tv, item.getType())
                        .setText(R.id.item_time_tv, item.getPublishedAt());

            }
        };
        baseQuickAdapter.setLoadMoreView(new SimpleLoadMoreView());
        baseQuickAdapter.setOnLoadMoreListener(() -> {
            if (!refreshLayout.isRefreshing()){
                mPresenter.loadQuery(type, pageSize, ++page);
            }
        }, recyclerView);
        recyclerView.setAdapter(baseQuickAdapter);
        refreshLayout.setRefreshing(true);
        mPresenter.getQuery(type, pageSize, page = 1);
        refreshLayout.setOnRefreshListener(() -> {
            if (!baseQuickAdapter.isLoading()) {
                refreshLayout.setRefreshing(true);
                mPresenter.getQuery(type, pageSize, page = 1);
            }
        });
    }

    BaseQuickAdapter<QueryBean.ResultsBean, BaseViewHolder> baseQuickAdapter;

    @Override
    public void setNewData(List<QueryBean.ResultsBean> mData) {
        baseQuickAdapter.setNewData(mData);
    }

    @Override
    public void addData(List<QueryBean.ResultsBean> mData) {
        baseQuickAdapter.addData(mData);
    }

    @Override
    public void stopRefresh() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void LoadComptle() {
        baseQuickAdapter.loadMoreComplete();
    }

    @Override
    public void loadFail() {
        baseQuickAdapter.loadMoreFail();
    }

    @Override
    public void loadEnd() {
        baseQuickAdapter.loadMoreEnd();
    }
}
