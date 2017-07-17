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
        //点击事件 方法一
        doubanMovieAdapter.setRecyclerItemClickListener(this);
        doubanMovieAdapter.setRecyclerItemLongClickListener(this);
        //点击事件 方法二
//        recyclerView.addOnItemTouchListener(new RecyclerItemOnTouchListener(recyclerView) {
//            @Override
//            public void onItemClick(RecyclerView.ViewHolder vh) {
//                Toast.makeText(getActivity(), "当前点击的是:" +vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLongItemClick(RecyclerView.ViewHolder vh) {
//                Toast.makeText(getActivity(), "当前长按的是:" +vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//            }
//        });
        //点击事件 方法三
//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            long startTime = 0;
//            boolean isLongPress;
//            boolean isPress;
//            RecyclerView.ViewHolder vh;
//
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                Log.v("onInterceptTouchEvent", e.getX() + "==" + e.getY() + "");
//                switch (e.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        startTime = System.currentTimeMillis();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        long endTime = System.currentTimeMillis();
//                        View view = rv.findChildViewUnder(e.getX(), e.getY());
//                        vh = rv.getChildViewHolder(view);
//                        if (endTime - startTime > 500) {
//                            isLongPress = true;
//                        } else {
//                            isPress = true;
//                            recyclerItemClick11("短时间点击", vh);
//                        }
//                        break;
//                }
//                if (isLongPress) {
//                    recyclerItemClick11("长时间点击时间", vh);
//                } else if (isPress) {
//                    recyclerItemClick11("短时间点击", vh);
//                }
//
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//                Log.v("onTouchEvent", e.getX() + "==" + e.getY() + "");
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        recyclerView.setAdapter(doubanMovieAdapter);
    }

    public void recyclerItemClick11(String msg, RecyclerView.ViewHolder vh) {
        Toast.makeText(getActivity(), msg + vh.getAdapterPosition(), Toast.LENGTH_LONG).show();
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
    public void setData(DoubanMovieBean doubanMovieBean) {
        isFirst = false;
        showContentView();
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
