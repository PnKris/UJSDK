package com.ujia.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class MultiAdapter<T> extends BaseAdapter<T> {
    ItemViewManager<T> itemViewManager;

    OnItemClickListener onItemClickListener;

    public MultiAdapter(Context context) {
        super(context);
        itemViewManager = new ItemViewManager<>();
    }


    @Override
    final public int getItemViewType(int position) {
        super.getItemViewType(position);
        T entity = getItem(position);
        return itemViewManager.getItemViewType(entity, position);
    }

    @NonNull
    @Override
    final public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemView<T> itemView = itemViewManager.getItemView(viewType);
        int layoutId = itemView.getItemLayoutId();
        ViewHolder holder = ViewHolder.createHolder(mContext, parent, layoutId);
        holder.itemView.setTag(holder);
        setListeners(holder);
        return holder;
    }

    private void setListeners(ViewHolder holder) {
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    ViewHolder viewHolder = (ViewHolder) v.getTag();
                    int position = viewHolder.getAdapterPosition();
                    onItemClickListener.onItemClick(viewHolder.itemView, viewHolder, position);
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    final public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        T entity = getItem(position);
        itemViewManager.convert(holder, entity, position);
    }

    public void addItemView(int viewType, ItemView<T> itemView) {
        itemViewManager.addItemView(viewType, itemView);
    }

    protected void onViewHolderCreated(ViewHolder holder, View itemView) {
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
