package com.leoyou.appleo.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoyou.appleo.photo.ImageLoader;

import java.util.LinkedHashSet;

/**
 * Created by Administrator on 2016/12/1.
 */

public class BaseViewHolder {
    View convertView;
    SparseArray<View> spaViews;
    private LinkedHashSet<Integer> childClickViewIds;


    private BaseViewHolder(int layoutId, ViewGroup parent, Context mContext) {
        convertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        childClickViewIds = new LinkedHashSet<>();
        spaViews = new SparseArray<>();
        convertView.setTag(this);
    }


    public static BaseViewHolder getViewHodler(int layoutId, ViewGroup parent, Context mContext, View convertView) {

        return convertView == null ? new BaseViewHolder(layoutId, parent, mContext) : (BaseViewHolder) convertView.getTag();
    }

    public View getReconView() {
        return convertView;
    }


    public <V extends View> V getView(int id) {
        View view = spaViews.get(id);
        if (view == null) {
            view = convertView.findViewById(id);
            spaViews.put(id, view);
        }
        return (V) view;
    }


    public BaseViewHolder setImage(int id, String url, int type) {
        ImageView imageView = getView(id);
        ImageLoader.disImage(imageView.getContext(), url, imageView);
        return this;
    }

    public BaseViewHolder setText(int id, CharSequence text) {
        View view = (TextView) getView(id);
        if (view instanceof Button)
            ((Button) view).setText(text);
        if (view instanceof TextView)
            ((TextView) view).setText(text);
        return this;
    }

    public BaseViewHolder setTextColor(int id, int textcolor) {
        TextView view = getView(id);
        view.setTextColor(textcolor);
        return this;
    }

    public BaseViewHolder setImage(int id, Bitmap bitmap) {
        ImageView imageView = getView(id);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int id, Drawable drawable) {
        ImageView imageView = getView(id);
        imageView.setImageDrawable(drawable);
        return this;
    }


    public BaseViewHolder setImageResource(int id, int resId) {
        ImageView imageView = getView(id);
        imageView.setImageResource(resId);
        return this;
    }

    public BaseViewHolder setOnClickListener(int id, View.OnClickListener listener) {
        View view = getView(id);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder addOnClickListener(int id) {
        childClickViewIds.add(id);
        return this;
    }

    public BaseViewHolder setTag(int id, Object tag) {
        View view = getView(id);
        view.setTag(tag);
        return this;
    }

    public BaseViewHolder setCheck(int id, boolean check) {
        View view = getView(id);
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(check);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setChecked(check);
        }
        return this;
    }


}
