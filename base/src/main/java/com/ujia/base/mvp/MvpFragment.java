package com.ujia.base.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ujia.base.BaseFragment;

public abstract class MvpFragment<P extends MvpPresenter> extends BaseFragment implements MvpView<P> {
    protected P mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract P initPresenter();

    protected void attachView() {

    }

    @Override
    public boolean isActive() {
        return isDetached();
    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onError() {

    }
}
