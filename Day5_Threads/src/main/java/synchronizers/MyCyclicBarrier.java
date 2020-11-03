package synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new MyThreadBarrier(c, "A");
        new MyThreadBarrier(c, "B");
        new MyThreadBarrier(c, "C");
    }
}

class MyThreadBarrier implements Runnable {
    CyclicBarrier cbar;
    String name;

    public MyThreadBarrier(CyclicBarrier cbar, String n) {
        this.cbar = cbar;

        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Барьер достигнут!");
    }
}
