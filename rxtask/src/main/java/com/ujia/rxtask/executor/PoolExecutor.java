package com.ujia.rxtask.executor;

import com.ujia.rxtask.Task;

public class PoolExecutor extends TaskExector {

    @Override
    public void submit(Task... tasks) {
        for (Task task : tasks) {
            ThreadPool.execute(task);
        }
    }
}
