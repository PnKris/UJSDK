package com.ujia.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    protected Context mContext;
    private List<T> entities = new ArrayList<>();

    public BaseAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return entities == null ? 0 : entities.size();
    }

    public void setList(List<T> entities) {
        this.entities.addAll(entities);
        notifyDataSetChanged();
    }

    public void addList(List<T> entities) {
        int start = this.entities.size();
        this.entities.addAll(entities);
        notifyItemRangeInserted(start, entities.size());
    }

    public T getItem(int position) {
        return this.entities.get(position);
    }


}
