package com.ujia.xrecyclerview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.ujia.refreshrecyclerview.R;

public class XRecyclerView extends SwipeRefreshLayout {
    private RecyclerView recyclerView;
    private Context context;

    private OnRefreshLoadMoreListener onRefreshLoadMoreListener;

    private LinearLayoutManager layoutManager = null;

    private boolean hasLoadMore = true;


    private OnRefreshListener onRefreshLister = new OnRefreshListener() {
        @Override
        public void onRefresh() {
            if (onRefreshLoadMoreListener != null) {
                onRefreshLoadMoreListener.onRefresh();
            }
        }
    };


    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) inflate(context, R.layout.lay_recyclerview, null);
        addView(recyclerView);
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (hasLoadMore && layoutManager.findLastVisibleItemPosition() + 1 == recyclerView.getAdapter().getItemCount()) {
                    if (onRefreshLoadMoreListener != null) {
                        onRefreshLoadMoreListener.onLoadMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("Kris", "onScrolled: ");
                if (hasLoadMore && layoutManager.findLastVisibleItemPosition() + 1 == recyclerView.getAdapter().getItemCount()) {
                    if (onRefreshLoadMoreListener != null) {
                        Log.d("Kris", "onScrolled: loadMore");
                        //#issue   如果直接调用onLoadMore 会发生
                        // Cannot call this method in a scroll callback.
                        // Scroll callbacks might be run during a measure & layout pass where you
                        // cannot change the RecyclerView data
                        recyclerView.post(new Runnable() {
                            @Override
                            public void run() {
                                onRefreshLoadMoreListener.onLoadMore();
                            }
                        });
                    }
                }
            }
        });
        this.setOnRefreshListener(onRefreshLister);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        this.recyclerView.setLayoutManager(layoutManager);
    }

    public void setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.onRefreshLoadMoreListener = onRefreshLoadMoreListener;
    }

    public void addItemDecoration(RecyclerView.ItemDecoration decor) {
        this.recyclerView.addItemDecoration(decor);
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public void refresh() {
        if (onRefreshLoadMoreListener != null) {
            onRefreshLoadMoreListener.onRefresh();
        }
    }

    public void loadMore() {
        if (onRefreshLoadMoreListener != null) {
            onRefreshLoadMoreListener.onLoadMore();
        }
    }

    public void setHasLoadMore(boolean hasLoadMore) {
        this.hasLoadMore = hasLoadMore;
    }

    public void setHasRefreshed(boolean refreshed) {
        setRefreshing(!refreshed);
    }
}

