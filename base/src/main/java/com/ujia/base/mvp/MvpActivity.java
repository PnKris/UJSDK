package com.ujia.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ujia.base.BaseActivity;

public abstract class MvpActivity<P extends MvpPresenter> extends BaseActivity implements MvpView<P> {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    protected abstract P initPresenter();

    @Override
    public boolean isActive() {
        return !isFinishing();
    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onError() {

    }
}
