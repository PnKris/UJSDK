package com.ujia.rxtask;

import android.support.annotation.NonNull;

import java.util.concurrent.FutureTask;

public class Worker<R, T> extends FutureTask {
    public Worker(@NonNull Task<T> runnable, R result) {
        super(runnable, result);
    }
}
