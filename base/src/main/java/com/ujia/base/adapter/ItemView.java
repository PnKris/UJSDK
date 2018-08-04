package com.ujia.base.adapter;

public interface ItemView<T> {
    int getItemLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder viewHolder, T entity, int position);
}
