package com.ujia.base.adapter;//package com.yuexin.common.adapter;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public abstract class SingleAdapter<T, VH extends BaseAdapter.BaseHolder> extends BaseAdapter<T> {
//
//    public SingleAdapter(Context context) {
//        super(context);
//    }
//
//    public abstract int onInitLayout();
//
//    public abstract void onBindHolder(BaseHolder holder, int position, T entity);
//
//
//    @NonNull
//    @Override
//    public BaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(onInitLayout(),
//                null, false);
//
//        return onCreateHolder();
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull BaseHolder holder, int position) {
//        T entity = entities.get(position);
//        onBindHolder(holder, position, entity);
//
//    }
//
//    public static class SingleHolder extends BaseHolder {
//
//        public SingleHolder(View itemView, int layId) {
//            super(itemView, layId);
//        }
//
//
//    }
//}
