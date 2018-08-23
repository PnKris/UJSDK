package com.ujia.rxtask;

import android.os.Looper;

public abstract class Task<T> implements Runnable {
    Callback target;

    public abstract T doBackground();

    @Override
    final public void run() {
        final T t = doBackground();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            target.onResult(t);
        } else {
            TaskHandler.post(new Runnable() {
                @Override
                public void run() {
                    target.onResult(t);
                }
            });
        }
    }
}
