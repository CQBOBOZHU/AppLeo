package com.leoyou.appleo.ui.fragment.douban;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseFragment;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.ui.adapter.DoubanMovieAdapter;
import com.leoyou.appleo.ui.adapter.listener.IRecyclerItemClickListener;
import com.leoyou.appleo.ui.adapter.listener.IRecyclerItemLongClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanFragment extends BaseFragment<DoubanController.IDoubanView,DoubanPresenter> implements DoubanController.IDoubanView, IRecyclerItemClickListener, IRecyclerItemLongClickListener {
    RecyclerView recyclerView;
    DoubanMovieAdapter doubanMovieAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        doubanMovieAdapter = new DoubanMovieAdapter(R.layout.item_douban_movie, null);
        doubanMovieAdapter.setRecyclerItemClickListener(this);
        doubanMovieAdapter.setRecyclerItemLongClickListener(this);
        recyclerView.setAdapter(doubanMovieAdapter);
    }



    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    public void initData() {
        if (isFirst && isPrepared && isVisible) {
            onrefresh();
        }
    }

    @Override
    public void onrefresh() {
        showLoadingView();
        mPresenter.onrefresh();
    }

    @Override
    public void onLoadMore() {
        mPresenter.onLoadMore();
    }

    @Override
    public void setData(List<DoubanMovieBean.SubjectsBean> subjectsBeens) {
        isFirst = false;
        showContentView();
        doubanMovieAdapter.setmData(subjectsBeens);
    }

    @Override
    public void addData(List<DoubanMovieBean.SubjectsBean> subjectsBeens) {
        doubanMovieAdapter.addData(subjectsBeens);
    }

    @Override
    public void showHint(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBaseView(int code) {
        switch (code) {
            case 0:
                showLoadingView();
                break;
            case 1:
                showContentView();
                break;
            case 2:
                showLoadErrorView();
                break;
            case 3:
                showNetErrorView();
                break;
            case 4:
                showEmptyView();
                break;
        }
    }

    public static Fragment newInstance() {

        return new DoubanFragment();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        initData();
    }

    @Override
    public void recyclerItemClick(int position) {
        Toast.makeText(getActivity(), doubanMovieAdapter.getmData().get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void recyclerItemLongClick(int position) {
        Toast.makeText(getActivity(), "还多按5秒,这部" + doubanMovieAdapter.getmData().get(position).getTitle() + "就能马上播放。", Toast.LENGTH_SHORT).show();
    }
}
