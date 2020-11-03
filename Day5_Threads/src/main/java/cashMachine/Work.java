package cashMachine;

import java.util.concurrent.Semaphore;

public class Work {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);

        ATM atm = new ATM(1000);

        new Thread(new User(atm, "Alisa")).start();
        new Thread(new User(atm, "Bob")).start();
        new Thread(new User(atm, "Eva")).start();

    }
}
