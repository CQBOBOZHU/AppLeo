package com.leoyou.appleo.ui.fragment.book;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.leoyou.appleo.R;
import com.leoyou.appleo.base.BaseFragment;
import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.ui.adapter.BookAdapter;
import com.leoyou.appleo.ui.adapter.listener.RecyclerItemOnTouchListener;

/**
 * Created by Administrator on 2017/5/8.
 *
 *
 */
public class BookFragment extends BaseFragment<BookPresenter> implements BookController.IBookView {
    RecyclerView recyclerView;
    BookAdapter bookAdapter;
    XRefreshView xrefreshView;

    public static BookFragment newInstance() {
        Bundle args = new Bundle();
        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    public void onResume() {
        super.onResume();
        xrefreshView.startRefresh();
    }

    @Override
    protected void initView() {
        recyclerView = getView(R.id.book_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.addOnItemTouchListener(new RecyclerItemOnTouchListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Toast.makeText(getActivity(), "点你妹"+vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(RecyclerView.ViewHolder vh) {
                Toast.makeText(getActivity(), "呵呵,居然还知道长按"+vh.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
        bookAdapter = new BookAdapter(R.layout.item_book, getActivity(), null);
        recyclerView.setAdapter(bookAdapter);
        xrefreshView = getView(R.id.xrefreshView);
        xrefreshView.setAutoRefresh(true);
        xrefreshView.setPullLoadEnable(true);
        xrefreshView.setPinnedTime(1000);
        xrefreshView.setAutoLoadMore(false);
        bookAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));
        xrefreshView.setEmptyView(getEmptyView());
        xrefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh(boolean isPullDown) {
                if (isPullDown) {
                    isFirst = true;
                }
                loading();
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                loadMore();
            }

        });
    }

    @Override
    protected BookPresenter getPresenter() {
        return new BookPresenter(this);
    }

    @Override
    public void showHint(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loading() {
        if (isFirst && isPrepared && isVisible) {
            mPresenter.loadData();
        } else {
            stopRefresh(true);
        }
    }

    @Override
    public void loadMore() {
        mPresenter.loadMoreData();
    }

    @Override
    public void setNewData(BookBean t) {
        if (t.getBooks().size() == 0) {
            showEmptyView(true);
        } else {
            isFirst = false;
            showEmptyView(false);
            bookAdapter.setmData(t.getBooks());
        }
    }

    @Override
    public void addData(BookBean t) {
        bookAdapter.addmData(t.getBooks());
    }

    private void showEmptyView(boolean isShow) {
        if (isShow) {
            if (xrefreshView.getEmptyView().getVisibility() != View.VISIBLE) {
                xrefreshView.getEmptyView().setVisibility(View.VISIBLE);
            }
        } else {
            if (xrefreshView.getEmptyView().getVisibility() != View.GONE) {
                xrefreshView.getEmptyView().setVisibility(View.GONE);
            }
        }
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
                showloadErrorView();
                break;
            case 3:
                showEmptyView(true);
                break;
            case 4:
                showEmptyView();
                break;
        }
    }

    @Override
    public void stopRefresh(boolean isSuccess) {
        xrefreshView.stopRefresh(isSuccess);
    }

    @Override
    public void stopLoadMore(boolean isSuccess) {
        xrefreshView.stopLoadMore(isSuccess);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && xrefreshView != null&&isFirst) {
            showLoadingView();
            loading();
        }
    }
}
