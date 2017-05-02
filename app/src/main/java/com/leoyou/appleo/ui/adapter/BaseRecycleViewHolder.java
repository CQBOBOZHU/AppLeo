package com.leoyou.appleo.ui.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashSet;

/**
 * Created by Administrator on 2016/12/1.
 */

public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {
    SparseArray<View> views;
    BaseRecycleViewHolder viewHolder;
    View rootView;
    private final LinkedHashSet<Integer> childClickViewIds;

    public BaseRecycleViewHolder(View itemView) {
        super(itemView);
        viewHolder = this;
        rootView = itemView;
        views = new SparseArray<>();
        childClickViewIds = new LinkedHashSet<>();
        rootView.setTag(this);
    }


    public View getRootView() {
        return rootView;
    }

    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = rootView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    public BaseRecycleViewHolder getText(int id, CharSequence charS) {
        TextView textView = getView(id);
        textView.setText(charS);
        return this;
    }


    public BaseRecycleViewHolder setText(int id, CharSequence text) {
        TextView textView = getView(id);
        textView.setText(text);
        return this;
    }

    public BaseRecycleViewHolder setTextColor(int id, int textcolor) {
        TextView view = getView(id);
        view.setTextColor(textcolor);
        return this;
    }

    public BaseRecycleViewHolder setImage(int id, Bitmap bitmap) {
        ImageView imageView = getView(id);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public BaseRecycleViewHolder setImageDrawable(int id, Drawable drawable) {
        ImageView imageView = getView(id);
        imageView.setImageDrawable(drawable);
        return this;
    }


    public BaseRecycleViewHolder setImageResource(int id, int resId) {
        ImageView imageView = getView(id);
        imageView.setImageResource(resId);
        return this;
    }

    public BaseRecycleViewHolder setOnClickListener(int id, View.OnClickListener listener) {
        View view = getView(id);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseRecycleViewHolder setOnClickListener(View.OnClickListener listener, int... ids) {
        for (int id : ids) {
            View view = getView(id);
            view.setOnClickListener(listener);
        }
        return this;
    }


    public BaseRecycleViewHolder addOnClickListener(int id) {
        childClickViewIds.add(id);
        return this;
    }

    public BaseRecycleViewHolder setTag(int id, Object tag) {
        View view = getView(id);
        view.setTag(tag);
        return this;
    }

    public BaseRecycleViewHolder setCheck(int id, boolean check) {
        View view = getView(id);
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(check);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setChecked(check);
        }
        return this;
    }
}
