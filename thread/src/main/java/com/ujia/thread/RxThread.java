package com.ujia.thread;

public class RxThread {
    /**
     * 异步线程执行,UI线程返回
     *
     * @param task
     */
    public static <T> void postOnMain(Task<T> task, Callback<T> callback) {
        task.target = callback;
        new Thread(task).start();
    }
}
