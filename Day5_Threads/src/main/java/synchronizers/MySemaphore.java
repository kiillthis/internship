package synchronizers;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new IncThread("A", semaphore);
        new DecThread("B", semaphore);
    }

}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    public IncThread(String name, java.util.concurrent.Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);

        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    public DecThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока " + name);

        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e ) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}