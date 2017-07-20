package com.leoyou.appleo.ui.dialog;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.leoyou.appleo.R;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewAdapter;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewHolder;
import com.leoyou.appleo.ui.wight.MyDecoration;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */

public class BottomSheetRecyclerDialog {
    Context mContext;

    public BottomSheetRecyclerDialog(Context mContext) {
        this.mContext = mContext;
        create();
    }

    MyBottomSheetDialog dialog;
    Adapter adapter;

    public void create() {
        RecyclerView recyclerView = new RecyclerView(mContext);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDecoration(mContext, LinearLayoutManager.HORIZONTAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.item_tv, null);
        recyclerView.setAdapter(adapter);
        dialog = new MyBottomSheetDialog(mContext);
        dialog.setContentView(recyclerView);
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    public void setNewData(List<String> mData) {
//        adapter.setNewData(mData);
        adapter.notifyDataSetChanged();
    }

    public class Adapter extends BaseRecycleViewAdapter<String, BaseRecycleViewHolder> {

        public Adapter(int layoutId, List<String> mData) {
            super(layoutId, mData);
        }


        @Override
        public void onBdViewHolder(BaseRecycleViewHolder viewHolder, int position) {

        }

        @Override
        public void onBindViewHolder(final BaseRecycleViewHolder holder, final int position) {
            holder.setText(R.id.item_tv, mData.get(position));
            holder.itemView.setOnClickListener(v -> {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(position,
                            mData.get(position));
                }
            });
        }


    }

    public interface OnItemClickListener {
        void onItemClick(int position, String text);
    }

    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mItemClickListener = li;
    }

}
