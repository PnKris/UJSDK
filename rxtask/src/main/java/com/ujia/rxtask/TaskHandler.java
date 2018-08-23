package com.ujia.rxtask;

import android.os.Handler;
import android.os.Looper;

public final class TaskHandler {
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public TaskHandler() {
    }

    public static void post(Runnable r) {
        handler.post(r);
    }

    public static void postDelayed(Runnable r, long delayMillis) {
        handler.postDelayed(r, delayMillis);
    }

    public static void removeCallbacks(Runnable r) {
        handler.removeCallbacks(r);
    }

    public static Handler getHandler() {
        return handler;
    }
}
