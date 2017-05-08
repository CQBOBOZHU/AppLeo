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

/**
 * Created by Administrator on 2016/12/1.
 */

public class XBaseRecycleViewHolder extends RecyclerView.ViewHolder {
    SparseArray<View> views;
    View rootView;

    public XBaseRecycleViewHolder(View itemView, boolean isItem) {
        super(itemView);
        if (isItem) {
            rootView = itemView;
            views = new SparseArray<>();
            rootView.setTag(this);
        }
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

    public XBaseRecycleViewHolder getText(int id, CharSequence charS) {
        TextView textView = getView(id);
        textView.setText(charS);
        return this;
    }


    public XBaseRecycleViewHolder setText(int id, CharSequence text) {
        TextView textView = getView(id);
        textView.setText(text);
        return this;
    }

    public XBaseRecycleViewHolder setTextColor(int id, int textcolor) {
        TextView view = getView(id);
        view.setTextColor(textcolor);
        return this;
    }

    public XBaseRecycleViewHolder setImage(int id, Bitmap bitmap) {
        ImageView imageView = getView(id);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public XBaseRecycleViewHolder setImageDrawable(int id, Drawable drawable) {
        ImageView imageView = getView(id);
        imageView.setImageDrawable(drawable);
        return this;
    }


    public XBaseRecycleViewHolder setImageResource(int id, int resId) {
        ImageView imageView = getView(id);
        imageView.setImageResource(resId);
        return this;
    }

    public XBaseRecycleViewHolder setOnClickListener(int id, View.OnClickListener listener) {
        View view = getView(id);
        view.setOnClickListener(listener);
        return this;
    }

    public XBaseRecycleViewHolder setOnClickListener(View.OnClickListener listener, int... ids) {
        for (int id : ids) {
            View view = getView(id);
            view.setOnClickListener(listener);
        }
        return this;
    }


    public XBaseRecycleViewHolder setTag(int id, Object tag) {
        View view = getView(id);
        view.setTag(tag);
        return this;
    }

    public XBaseRecycleViewHolder setCheck(int id, boolean check) {
        View view = getView(id);
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(check);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setChecked(check);
        }
        return this;
    }

    public XBaseRecycleViewHolder setVisible(int id, int visible) {
        View view = getView(id);
        view.setVisibility(visible);
        return this;
    }
}
