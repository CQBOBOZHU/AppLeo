package com.leoyou.appleo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.leoyou.appleo.R;
import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.photo.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */

public class BookAdapter extends BaseRecyclerAdapter<XBaseRecycleViewHolder> {
    int layoutId;
    List<BookBean.BooksBean> mData;
    Context context;
    LayoutInflater inflater;

    public BookAdapter(int layoutId, Context context, List<BookBean.BooksBean> mData) {
        this.layoutId = layoutId;
        this.mData = mData;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
//
//    @Override
//    public void onBdViewHolder(BaseRecycleViewHolder viewHolder, int position) {
//        viewHolder.setText(R.id.item_bookName_tv,mData.get(position).getTitle());
//        ImageLoader.disImage(mContext,mData.get(position).getImage(), (ImageView) viewHolder.getView(R.id.item_bookImage));
//    }


    @Override
    public XBaseRecycleViewHolder getViewHolder(View view) {
        return new XBaseRecycleViewHolder(view,false);
    }

    /**
     * @param parent
     * @param viewType
     * @param isItem   如果是true，才需要做处理 ,但是这个值总是true
     */
    @Override
    public XBaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = inflater.inflate(layoutId, parent, false);
        return new XBaseRecycleViewHolder(view,true);
    }

    /**
     * 替代onBindViewHolder方法，实现这个方法就行了
     *
     * @param viewHolder
     * @param position
     * @param isItem
     */
    @Override
    public void onBindViewHolder(XBaseRecycleViewHolder viewHolder, int position, boolean isItem) {
        viewHolder.setText(R.id.item_bookName_tv,mData.get(position).getTitle());
        ImageLoader.disImage(context,mData.get(position).getImage(), (ImageView) viewHolder.getView(R.id.item_bookImage));
//
    }

    public List<BookBean.BooksBean> getmData() {
        return mData;
    }

    public void setmData(List<BookBean.BooksBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void addmData(List<BookBean.BooksBean> data) {
        for (BookBean.BooksBean bean : data) {
            insert(mData, bean, getAdapterItemCount());
        }
    }

    /**
     * Returns the number of items in the adapter bound to the parent
     * RecyclerView.
     *
     * @return The number of items in the bound adapter
     */
    @Override
    public int getAdapterItemCount() {
        return mData != null ? mData.size() : 0;
    }
}
