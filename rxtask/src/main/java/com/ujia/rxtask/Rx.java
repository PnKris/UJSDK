package com.ujia.rxtask;

import com.ujia.rxtask.executor.ThreadPool;

final class Rx {

    private Task task;
    private Callback target;
    private long delay;

    public Rx() {
    }

    public Rx(Builder builder) {
        task = builder.task;
        target = builder.target;
        delay = builder.delay;
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

    public void post() {
        TaskHandler.post(task);
    }

    public void postDelay() {
        TaskHandler.postDelayed(task, delay);
    }

    public static class Builder {
        private long delay;
        private Task<?> task;
        private Callback<?> target;

        public Builder delay(long delay) {
            this.delay = delay;
            return this;
        }

        public Builder task(Task<?> task) {
            this.task = task;
            return this;
        }

        public Builder target(Callback<?> target) {
            this.target = target;
            return this;
        }

        public Rx build() {
            return new Rx(this);
        }
    }
}


