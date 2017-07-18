package com.leoyou.appleo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leoyou.appleo.ui.adapter.listener.IRecyclerItemClickListener;
import com.leoyou.appleo.ui.adapter.listener.IRecyclerItemLongClickListener;

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
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        K baseViewHolder = (K) new BaseRecycleViewHolder(view);
        return baseViewHolder;
    }

    public void setmData(List<T> data) {
        this.mData = data;
        this.notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        int start = getItemCount();
        this.mData.addAll(data);
        notifyItemRangeInserted(start, getItemCount());
    }

    public List<T> getmData() {
        return mData;
    }

    public void insertData(List<T> data) {
        for (T t : data) {
            insertData(t, getItemCount());
        }
    }

    public void insertData(T bean, int position) {
        this.mData.add(position, bean);
        notifyItemChanged(position);
    }

    public abstract void onBdViewHolder(K viewHolder, final int position);

    @Override
    public void onBindViewHolder(BaseRecycleViewHolder holder, final int position) {
        holder.getRootView().setOnClickListener(v -> {
            if (recyclerItemClickListener != null) {
                recyclerItemClickListener.recyclerItemClick(position);
            }
        });
        holder.getRootView().setOnLongClickListener(v -> {
            if (recyclerItemLongClickListener!=null){
                recyclerItemLongClickListener.recyclerItemLongClick(position);
                return true;
            }
            return false;
        });
        onBdViewHolder((K) holder, position);
    }

    @Override
    public int getItemCount() {
        return null != mData ? mData.size() : 0;
    }

    IRecyclerItemClickListener recyclerItemClickListener;

    public void setRecyclerItemClickListener(IRecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    IRecyclerItemLongClickListener recyclerItemLongClickListener;

    public void setRecyclerItemLongClickListener(IRecyclerItemLongClickListener recyclerItemLongClickListener) {
        this.recyclerItemLongClickListener = recyclerItemLongClickListener;
    }
}
