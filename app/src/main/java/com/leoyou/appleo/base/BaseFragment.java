package com.leoyou.appleo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.leoyou.appleo.R;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2017/5/3.
 */

public abstract class BaseFragment<V extends BaseView,P extends BasePresenterImpl<V>> extends Fragment implements BaseView{
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
        mPresenter = getInstance(this,1);
        mPresenter.attachView((V) this);
        initView();
        isPrepared=true;
        return baseView;
    }





    public <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected abstract int getLayoutId();

    protected abstract void initView();


    public <T extends View> T getView(int viewId) {
        return (T) baseView.findViewById(viewId);
    }

    public void showEmptyView() {
        showView(R.id.base_empty_viewstub);
    }

    public void showLoadingView() {
        showView(R.id.base_loading_viewstub);
    }
    /**
     * 加载错误布局
     */
    @Override
    public void showLoadErrorView() {
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
                    btn.setOnClickListener(v -> loadMessage());
            }

        }
        view.setVisibility(View.VISIBLE);
    }

    public  View  getEmptyView(){
        View view = sparseArray.get(R.id.base_empty_viewstub);
        if (view==null){
            ViewStub viewStub = getView(R.id.base_empty_viewstub);
            view = viewStub.inflate();
            sparseArray.put(R.id.base_empty_viewstub, view);
        }
        return view;
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

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirst=true;
        mPresenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * 加载activity
     *
     * @param cls
     * @param bundle
     */
    @Override
    public void startActivity(Class cls, Bundle bundle) {

    }

    /**
     * 加载activity
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    @Override
    public void startActivityForResult(Class cls, Bundle bundle, int requestCode) {

    }

    /**
     * 加载多个activity
     *
     * @param bundle
     * @param classes
     */
    @Override
    public void startMoreActivity(Bundle bundle, Class... classes) {

    }

    /**
     * 现在加载中的dialog
     */
    @Override
    public void showLoadingDialog() {

    }

    /**
     * 关闭dialog
     */
    @Override
    public void stopLoadingDialog() {

    }



    /**
     * 提示消息
     *
     * @param msg
     */
    @Override
    public void showMessage(String msg) {

    }

    /**
     * 关闭activity
     */
    @Override
    public void closeActivity() {

    }

    /**
     * 关闭activity
     *
     * @param resultCode
     */
    @Override
    public void closeActivity(int resultCode) {

    }

    /**
     * 注销账户
     */
    @Override
    public void logOffUserInfo() {

    }

    /**
     * 设置view的visible
     *
     * @param visible
     */
    @Override
    public void setViewVisible(int visible) {

    }
}
