package com.ujia.rxtask;

public class RxTask {

    public static <T> Rx io(Task<T> task) {
        Rx rx = new Rx();
        return rx.io(task);
    }

}
