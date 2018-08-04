package com.ujia.base.mvp;

public interface MvpView<T extends MvpPresenter> {
//    public void setPresenter(T presenter);

    public boolean isActive();

    void onError();

    void onEmpty();
}
