package com.ujia.rxtask;

public final class Rx {

    private Task task;

    public Rx() {
    }

    protected <T> Rx io(Task<T> task) {
        this.task = task;
        return this;
    }


    public <T> void call(Callback<T> target) {
        task.target = target;
        ThreadPool.execute(task);
    }

}


