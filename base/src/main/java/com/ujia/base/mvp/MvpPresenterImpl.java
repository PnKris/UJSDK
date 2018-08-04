package com.ujia.base.mvp;

import android.os.Handler;

import java.lang.ref.WeakReference;

public class MvpPresenterImpl<V extends MvpView> implements MvpPresenter {
    protected WeakReference<V> mViewRef;

    public MvpPresenterImpl(V view) {
        mViewRef = new WeakReference<>(view);
//        mViewRef.get().setPresenter(this);
    }

    protected boolean isViewActive() {
        return mViewRef != null && mViewRef.get() != null && mViewRef.get().isActive();
    }

    protected void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected V obtainView() {
        return mViewRef.get();
    }

}
