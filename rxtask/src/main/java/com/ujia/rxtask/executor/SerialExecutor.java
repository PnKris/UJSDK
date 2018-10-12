package com.ujia.rxtask.executor;

import com.ujia.rxtask.Task;
import com.ujia.rxtask.Worker;

public class SerialExecutor extends TaskExector {

    @Override
    public void submit(final Task... tasks) {
        ThreadPool.execute(new Runnable() {
            @Override
            public void run() {

                for(Task task:tasks) {
                    SerialExecutor.this.run(task);
                }
            }
        });
    }

    private void run(Task task){
    }
}
