import java.util.concurrent.Exchanger;

public class Task3 {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<String>();

        new Producer(exgr);
        new Consumer(exgr);
    }
}

class Consumer implements Runnable {
    Exchanger<String> ex;
    String num;

    public Consumer(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                num = ex.exchange("");
                System.out.println("Получено " + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable {
    Exchanger<String> ex;
    String num;

    public Producer(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            this.num = String.valueOf((int) (Math.random() * 20));

            try {
//                System.out.println("Отправлено " + num);
                num = ex.exchange(num);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
