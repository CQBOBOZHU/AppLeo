package com.leoyou.appleo.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;
import com.leoyou.appleo.R;

/**
 * Created by Administrator on 2017/4/20.
 */

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity {
    public P mPresenter;
    public V mBaseView;
    View baseView;
    View contentView;
    SparseArray<View> sparseArray = new SparseArray<>();
    int layoutResID;
    View toobarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBaseView = getIView();
        mPresenter = getPresenter();
        initStatusBar();
        initView(savedInstanceState);
    }

    private void initStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent), 0);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        baseView = LayoutInflater.from(this).inflate(R.layout.activity_base, null, false);
        this.layoutResID = layoutResID;
        contentView = getLayoutInflater().inflate(layoutResID, null, false);
        sparseArray.put(layoutResID, contentView);
        if (getToobarId() != 0)
            toobarView = getLayoutInflater().inflate(getToobarId(), null, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(layoutParams);
        FrameLayout toobar_layout = getView(R.id.base_toolbar_view);
        if (toobarView != null) {
            toobarView.setLayoutParams(layoutParams);
            toobar_layout.addView(toobarView);
        } else {
            toobar_layout.setVisibility(View.GONE);
        }
        FrameLayout frameLayout = getView(R.id.base_contentView);
        frameLayout.addView(contentView);
        getWindow().setContentView(baseView);
    }

    public void showEmptyView() {
        showView(R.id.base_empty_viewstub);
    }

    public void showLoadView() {
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

    protected abstract int getToobarId();


    /**
     * 加载失败和网络错误后，点击按钮
     */
    protected void loadMessage() {
    }


    protected abstract V getIView();

    protected abstract int getLayoutId();

    public abstract P getPresenter();

    protected abstract void initView(Bundle savedInstanceState);

    public  <T extends View> T getView(int viewId){

        return (T) baseView.findViewById(viewId);
    }
}
