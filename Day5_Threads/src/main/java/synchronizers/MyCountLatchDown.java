package synchronizers;

import java.util.concurrent.CountDownLatch;

public class MyCountLatchDown {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("Start");

        new MyThread(countDownLatch);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Завершение потока");
    }

}

class MyThread implements Runnable {
    CountDownLatch lath;

    public MyThread(CountDownLatch lath) {
        this.lath = lath;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            lath.countDown();
        }
    }
}
