package com.ujia.rxtask;

public abstract class Task<T> implements Runnable {
    Callback target;

    public abstract T doBackground();

    @Override
    final public void run() {
        final T t = doBackground();
        MainHandlerUtil.post(new Runnable() {
            @Override
            public void run() {
                target.onResult(t);
            }
        });
    }
}
