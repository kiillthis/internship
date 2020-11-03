package eckell;

import java.util.concurrent.Callable;

public class TaskWithAResult implements Callable<String> {
    private int id;

    public TaskWithAResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result " + id;
    }
}
