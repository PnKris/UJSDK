package com.ujia.rxtask;

/**
 * 1、单个任务
 * 2、多个任务组合
 * 3、多个任务串行，下一个任务依赖上一个任务的结果
 * 4、多个任务串行，可以拦截后续任务
 * 5、延时作用
 */
public class RxTask {

    public static <T> Rx io(Task<T> task) {
        Rx rx = new Rx();
        return rx.io(task);
    }

    public static void post(Task task) {
        Rx rx = new Rx.Builder().task(task).build();
        rx.post();
    }

    public static void postDelay(Task task, long delay) {
        Rx rx = new Rx.Builder().task(task).delay(delay).build();
        rx.postDelay();
    }


}
