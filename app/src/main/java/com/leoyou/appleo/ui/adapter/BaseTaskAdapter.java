package com.leoyou.appleo.ui.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Callback;

/**
 * Created by Administrator on 2016/12/1.
 */

public abstract class BaseTaskAdapter<T> extends BaseAdapter  {
    public List<T> mData;
    public Context mContext;
    public int layoutId;
    List<Integer> viewTypes;
    Handler handler = new Handler(Looper.getMainLooper());

    public BaseTaskAdapter(List<T> mData, Context mContext, int layoutId) {
        this.mData = mData == null ? new ArrayList<T>() : mData;
        this.mContext = mContext;
        this.layoutId = layoutId;
        viewTypes = new ArrayList<>();
    }



    public List<Integer> getViewTypes() {
        return viewTypes;
    }

    public void setViewTypes(List<Integer> viewTypes) {
        this.viewTypes = viewTypes;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder baseViewHolder = BaseViewHolder.getViewHodler(layoutId, parent,mContext, convertView);
        convert(baseViewHolder, getItem(position), position);
        return baseViewHolder.getReconView();
    }


    public abstract void convert(BaseViewHolder bViewHoder, T t, int position);

    public void setNewData(List<T> newData) {
        this.mData = newData == null ? new ArrayList<T>() : newData;
        notifyDataSetChanged();
    }

    public void addData(int position, T newData) {
        this.mData.add(position, newData);
        notifyDataSetChanged();
    }

    public void addData(List<T> newData) {
        this.mData.addAll(newData);
        notifyDataSetChanged();
    }

}
