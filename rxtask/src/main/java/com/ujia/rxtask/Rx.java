package com.ujia.rxtask;

import java.util.Queue;

public final class Rx {



    private Task task;

    public Rx() {
    }

    protected <T> Rx io(Task<T> task) {
        this.task = task;
        return this;
    }

    protected <T> Rx job(Task<T> task) {
        this.task = task;
        return this;
    }


    protected Rx schedule() {

        return this;
    }

    public <T> void call(Callback<T> target) {
        task.target = target;
        ThreadPool.execute(task);
    }

}


