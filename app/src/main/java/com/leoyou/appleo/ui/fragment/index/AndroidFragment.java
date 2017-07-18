package com.leoyou.appleo.ui.fragment.index;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseFragment;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewAdapter;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class AndroidFragment extends BaseFragment<IIndexView,IndexPresenter> implements IIndexView {
    RecyclerView recyclerView;

    public static AndroidFragment newInstance() {
        Bundle args = new Bundle();
        AndroidFragment fragment = new AndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }


    @Override
    protected void initView() {
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
    }


    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    List<FuliBean.ResultsBean> mRbs = new ArrayList<>();

    public void setData(List<FuliBean.ResultsBean> mRbs) {
        isFirst = false;
        if (mRbs != null && mRbs.size() > 0) {
            showContentView();
            recycleViewAdapter.setmData(mRbs);
        } else {
            showEmptyView();
        }
    }

    public void showHint(Object o) {
        Toast.makeText(getContext(), o.toString(), Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        if (isFirst && isPrepared && isVisible) {
            mPresenter.loadData("Android");
        }
    }


    BaseRecycleViewAdapter recycleViewAdapter = new BaseRecycleViewAdapter<FuliBean.ResultsBean, BaseRecycleViewHolder>(R.layout.fragment_android, mRbs) {
        @Override
        public void onBdViewHolder(BaseRecycleViewHolder viewHolder, int position) {
            viewHolder.setText(R.id.item_an_title, mData.get(position).getDesc());
            viewHolder.setText(R.id.item_an_time, mData.get(position).getCreatedAt());
            viewHolder.setText(R.id.item_an_from, mData.get(position).getWho());
        }
    };

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        loadData();
    }

    @Override
    protected void loadMessage() {
        loadData();
    }
}
