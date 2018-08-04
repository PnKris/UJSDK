package com.ujia.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewHolder extends RecyclerView.ViewHolder {
    public SparseArray<View> views;
    public View itemView;

    public ViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        this.itemView = itemView;
    }

    public static ViewHolder createHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new ViewHolder(itemView);
    }

    public View getItemView() {
        return this.itemView;
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = this.itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
