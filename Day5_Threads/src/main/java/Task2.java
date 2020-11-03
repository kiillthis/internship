public class Task2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("Alisa"));
        Thread t2 = new Thread(new MyThread("Bob"));

        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println("My name is " + name);
//            try {
//                System.out.println("My name is " + name);
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                System.out.println("Exception is caught");
//            }
        }
    }
}
