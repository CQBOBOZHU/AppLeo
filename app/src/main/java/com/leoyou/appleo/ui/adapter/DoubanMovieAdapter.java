package com.leoyou.appleo.ui.adapter;

import android.widget.ImageView;

import com.leoyou.appleo.R;
import com.leoyou.appleo.bean.DoubanMovieBean;
import com.leoyou.appleo.photo.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */

public class DoubanMovieAdapter extends BaseRecycleViewAdapter<DoubanMovieBean.SubjectsBean, BaseRecycleViewHolder> {

    public DoubanMovieAdapter(int layoutId, List<DoubanMovieBean.SubjectsBean> mData) {
        super(layoutId, mData);
    }

    @Override
    public void onBdViewHolder(BaseRecycleViewHolder viewHolder, int position) {
        DoubanMovieBean.SubjectsBean subjectsBean=mData.get(position);
        ImageLoader.disImage(mContext,subjectsBean.getImages().getSmall(), (ImageView) viewHolder.getView(R.id.item_movie_img));
        viewHolder.setText(R.id.item_movie_title,subjectsBean.getTitle());
    }
}
