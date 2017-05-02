package com.leoyou.appleo.ui.fragment.index;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leoyou.appleo.R;
import com.leoyou.appleo.bean.FuliBean;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewAdapter;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewHolder;
import com.leoyou.appleo.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

public class AndroidFragment extends BaseFragment<IIndexView, IIndexPresenter> implements IIndexView {
    RecyclerView recyclerView;

    public static AndroidFragment newInstance() {
        Bundle args = new Bundle();
        AndroidFragment fragment = new AndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected IIndexPresenter getPresenter() {
        return new IndexPresenter(this);
    }

    @Override
    protected void initView() {
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
        mPresenter.initData("Android",20,1);
    }

    List<FuliBean.ResultsBean> mRbs = new ArrayList<>();

    @Override
    public void setData(List<FuliBean.ResultsBean> mRbs) {
        recycleViewAdapter.setmData(mRbs);
    }

    @Override
    public void showHint(Object o) {

    }

    BaseRecycleViewAdapter recycleViewAdapter = new BaseRecycleViewAdapter<FuliBean.ResultsBean, BaseRecycleViewHolder>(R.layout.fragment_android, mRbs) {
        @Override
        public void onBdViewHolder(BaseRecycleViewHolder viewHolder, int position) {
            viewHolder.setText(R.id.item_an_title, mData.get(position).getDesc());
            viewHolder.setText(R.id.item_an_time, mData.get(position).getCreatedAt());
            viewHolder.setText(R.id.item_an_from, mData.get(position).getWho());
        }

    };
}
