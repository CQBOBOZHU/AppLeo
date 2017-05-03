package com.leoyou.appleo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.leoyou.appleo.R;

/**
 * Created by Administrator on 2017/5/3.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    View baseView;
    public P mPresenter;
    SparseArray<View> sparseArray = new SparseArray<>();
    int layoutResID;
    public boolean isPrepared = false;
    public boolean isVisible = false;
    public boolean isFirst = true;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        baseView = layoutInflater.inflate(R.layout.fragment_base, null);
        FrameLayout contentParent = getView(R.id.base_contentView);
        layoutResID = getLayoutId();
        View rootView = layoutInflater.inflate(layoutResID, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.setLayoutParams(params);
        sparseArray.put(layoutResID, rootView);
        contentParent.addView(rootView);
        mPresenter = getPresenter();
        initView();
        isPrepared=true;
        return baseView;
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract P getPresenter();

    public <T extends View> T getView(int viewId) {
        return (T) baseView.findViewById(viewId);
    }

    public void showEmptyView() {
        showView(R.id.base_empty_viewstub);
    }

    public void showLoadingView() {
        showView(R.id.base_loading_viewstub);
    }

    public void showloadErrorView() {
        showView(R.id.base_loading_error_viewstub);
    }

    public void showNetErrorView() {
        showView(R.id.base_network_error_viewstub);
    }

    public void showContentView() {
        showView(layoutResID);
    }

    public void showView(int viewstubId) {

        for (int i = 0; i < sparseArray.size(); i++) {
            int key = sparseArray.keyAt(i);
            View view = sparseArray.get(key);
            view.setVisibility(View.GONE);
        }
        View view = sparseArray.get(viewstubId);
        if (null == view) {
            ViewStub viewStub = getView(viewstubId);
            view = viewStub.inflate();
            sparseArray.put(viewstubId, view);
            if (viewstubId == R.id.base_loading_error_viewstub || viewstubId == R.id.base_network_error_viewstub) {
                View btn = view.findViewById(R.id.loading_again_btn);
                if (btn != null)
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loadMessage();
                        }
                    });
            }

        }
        view.setVisibility(View.VISIBLE);
    }

    /**
     * 加载失败和网络错误后，点击按钮
     */
    protected void loadMessage() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible=isVisibleToUser;
    }
}
