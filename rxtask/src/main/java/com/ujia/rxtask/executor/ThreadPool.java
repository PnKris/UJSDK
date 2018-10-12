package com.ujia.rxtask.executor;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static final ThreadPoolExecutor poolExecutor;

    public static void execute(Runnable runnable) {
        poolExecutor.execute(runnable);
    }

    static {
        poolExecutor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }
}
