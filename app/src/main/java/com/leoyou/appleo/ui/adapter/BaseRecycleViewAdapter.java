package com.leoyou.appleo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by Administrator on 2016/12/1.
 */

public abstract class BaseRecycleViewAdapter<T, K extends BaseRecycleViewHolder> extends RecyclerView.Adapter<K> {
    public Context mContext;
    int layoutId;
    public List<T> mData;

    public BaseRecycleViewAdapter(int layoutId, List<T> mData) {
        this.layoutId = layoutId;
        this.mData = mData;
    }

    @Override
    public K onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent,false);
        K baseViewHolder = (K) new BaseRecycleViewHolder(view);
        return baseViewHolder;
    }

    public void setmData(List<T> mData) {
        this.mData = mData;
        this.notifyDataSetChanged();
    }

    public abstract void onBdViewHolder(K object, final int position);

    @Override
    public void onBindViewHolder(BaseRecycleViewHolder holder, final int position) {
        onBdViewHolder((K) holder, position);
    }

    @Override
    public int getItemCount() {
        if (mData == null && mData.size() == 0)
            return 0;
        else
            return mData.size();
    }
}
