package com.leoyou.appleo.ui.fragment.douban;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseFragment;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.ui.adapter.DoubanMovieAdapter;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanFragment extends BaseFragment<DoubanPresenter> implements DoubanContract.IDoubanView {
    RecyclerView recyclerView;
    DoubanMovieAdapter doubanMovieAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
        recyclerView = getView(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    protected DoubanPresenter getPresenter() {
        return new DoubanPresenter(this);
    }

    @Override
    public void onrefresh() {
        mPresenter.onrefresh();
    }

    @Override
    public void onLoadMore() {
        mPresenter.onLoadMore();
    }

    @Override
    public void setData(DoubanMovieBean doubanMovieBean) {
        showContentView();
        if (doubanMovieAdapter == null) {
            doubanMovieAdapter = new DoubanMovieAdapter(R.layout.item_douban_movie, doubanMovieBean.getSubjects());
        } else
            doubanMovieAdapter.setmData(doubanMovieBean.getSubjects());
    }

    @Override
    public void addData(DoubanMovieBean doubanMovieBean) {
        doubanMovieAdapter.addData(doubanMovieBean.getSubjects());
    }

    @Override
    public void showHint(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static Fragment newInstance() {

        return new DoubanFragment();
    }
}
