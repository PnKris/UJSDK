package com.ujia.base.adapter;

import android.util.SparseArray;

public class ItemViewManager<T> {
    SparseArray<ItemView> itemViews;

    public ItemViewManager() {
        itemViews = new SparseArray<>();

    }

    public void addItemView(int viewType, ItemView itemView) {
        itemViews.put(viewType, itemView);
    }


    public int getItemViewType(T item, int position) {
        int delegatesCount = itemViews.size();
        for (int i = delegatesCount - 1; i >= 0; i--) {
            ItemView<T> itemView = itemViews.valueAt(i);
            if (itemView.isForViewType(item, position)) {
                return itemViews.keyAt(i);
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegate added that matches position=" + position + " in data source");
    }

    public void convert(ViewHolder holder, T item, int position) {
        int delegatesCount = itemViews.size();
        for (int i = 0; i < delegatesCount; i++) {
            ItemView<T> itemView = itemViews.valueAt(i);

            if (itemView.isForViewType(item, position)) {
                itemView.convert(holder, item, position);
                return;
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position=" + position + " in data source");
    }


    public ItemView getItemView(int viewType) {
        return itemViews.get(viewType);
    }

    public int getItemViewLayoutId(int viewType) {
        return getItemView(viewType).getItemLayoutId();
    }

    public int getItemViewType(ItemView itemView) {
        return itemViews.indexOfValue(itemView);
    }


}
