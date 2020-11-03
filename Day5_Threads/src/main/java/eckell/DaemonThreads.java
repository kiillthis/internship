package eckell;

public class DaemonThreads implements Runnable {
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new DaemonThreads());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("Все демоны запущены");
        Thread.sleep(175);
    }
}
