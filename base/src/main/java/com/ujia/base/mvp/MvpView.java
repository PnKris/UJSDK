package com.ujia.base.mvp;

public interface MvpView<T extends MvpPresenter> {

    public boolean isActive();

    void onError();

    void onEmpty();
}
