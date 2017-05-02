package com.leoyou.appleo.ui.fragment.index;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.leoyou.appleo.R;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.photo.ImageLoader;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewAdapter;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewHolder;
import com.leoyou.appleo.ui.fragment.BaseFragment;
import com.leoyou.appleo.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class IndexFragment extends BaseFragment<IIndexView, IIndexPresenter> implements IIndexView {

    RecyclerView recyclerView;
    List<FuliBean.ResultsBean> fuliBeen = new ArrayList<>();

    public static IndexFragment newInstance(Bundle args) {
        IndexFragment fragment = new IndexFragment();
        if (args != null)
            fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected IIndexPresenter getPresenter() {
        return new IndexPresenter(mView);
    }

    @Override
    protected void initView() {
        recyclerView = getView(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mPresenter.initData();
        recyclerView.setAdapter(recycleViewAdapter);
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
        recycleViewAdapter.setmData(resultsBeans);
        recycleViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showHint(Object o) {
        Toast.makeText(getContext(), o.toString(), Toast.LENGTH_SHORT).show();
    }

}