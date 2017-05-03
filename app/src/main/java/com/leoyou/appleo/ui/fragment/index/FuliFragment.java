package com.leoyou.appleo.ui.fragment.index;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseFragment;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.photo.ImageLoader;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewAdapter;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewHolder;
import com.leoyou.appleo.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class FuliFragment extends BaseFragment<IIndexPresenter> implements IIndexView {

    RecyclerView recyclerView;
    List<FuliBean.ResultsBean> fuliBeen = new ArrayList<>();
    private String type = "福利";
    private int num = 10;
    private int page = 1;
    public boolean isLoading = false;

    public static FuliFragment newInstance(Bundle args) {
        FuliFragment fragment = new FuliFragment();
        if (args != null)
            fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected IIndexPresenter getPresenter() {
        return new IndexPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(recycleViewAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    public void loadData() {
        if (isFirst && isPrepared && isVisible) {
            if (!isLoading()) {
                setLoading(true);
                showLoadView();
                mPresenter.initData(type, num, page);
            }
        }
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    BaseRecycleViewAdapter recycleViewAdapter = new BaseRecycleViewAdapter<FuliBean.ResultsBean, BaseRecycleViewHolder>(R.layout.recycle_item, fuliBeen) {
        @Override
        public void onBdViewHolder(BaseRecycleViewHolder object, int position) {
            if (position % 2 == 0) {
                DensityUtil.setViewMargin(object.getRootView(), false, 12, 6, 12, 0);
            } else {
                DensityUtil.setViewMargin(object.getRootView(), false, 6, 12, 12, 0);
            }
            FuliBean.ResultsBean resultsBean = mData.get(position);
            object.setText(R.id.item_tv, "position" + resultsBean.getUrl());
            ImageView imageview = object.getView(R.id.item_image);
            ImageLoader.disImage(mContext, resultsBean.getUrl(), imageview);
        }

    };

    public void setData(List<FuliBean.ResultsBean> resultsBeans) {
        isFirst=false;
        if (resultsBeans == null || resultsBeans.size() == 0) {
            showEmptyView();
        } else {
            showContentView();
            recycleViewAdapter.setmData(resultsBeans);
            recycleViewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showHint(Object o) {
        Toast.makeText(getContext(), o.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        loadData();
    }
}
