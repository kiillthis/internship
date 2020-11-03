import eckell.TaskWithAResult;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) {
            results.add(ex.submit(new TaskWithAResult(i)));
        }

        for (Future<String> fs: results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                ex.shutdown();
            }
        }
    }
}
