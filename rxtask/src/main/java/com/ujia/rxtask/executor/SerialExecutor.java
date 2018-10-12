package com.ujia.rxtask.executor;

import com.ujia.rxtask.Task;

public class SerialExecutor extends TaskExector {

    @Override
    public void submit(final Task... tasks) {
        ThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                for (Task task : tasks) {
                    task.run();
                }
            }
        });
    }
}
