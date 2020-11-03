import sun.awt.windows.ThemeReader;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyThread1());
        System.out.println("Before " + t.getState());
        t.start();
        System.out.println("Running " + t.getState());
        Thread.sleep(100);
        System.out.println("After " + t.getState());
    }

}

class MyThread1 implements Runnable {
    public void run() {
        System.out.println("kek");
    }
}
