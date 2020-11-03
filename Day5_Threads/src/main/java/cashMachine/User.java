package cashMachine;

public class User implements Runnable {
    private ATM atm;
    private String name;

    public User(ATM atm, String name) {
        this.name = name;
        this.atm = atm;
    }

    public void run() {

        // synchronized (atm) {
        int numOfOperations = 2;

        for (int i = 0; i < numOfOperations; i++) {

            int sumTake = (int) (Math.random() * 200);

            int transaction = (int) (Math.random() * 100);



            boolean flag = true;
            int attempts = 0;

            while (flag) {
                System.out.println(transaction + " " + name + " делает транзакцию" + ". Сумма до: " + atm.getAccount());
                System.out.println(name + " пытается снять " + sumTake);
                waitTransaction();
                try {
                    int sleep = (int) (Math.random() * 10) * 1000;
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted " + e);
                }
                try {
                    atm.takeMoney(sumTake);
                    flag = false;
                } catch (IllegalArgumentException e) {
                    flag = true;
                    attempts++;
                }
                if (attempts == 3) {
                    System.out.println("В банкомате нет денег");
                    flag = false;
                }
            }
            System.out.println(transaction + " " + name + ". Сумма после: " + atm.getAccount());
        }

        //}

    }

    private void waitTransaction() {
        try {
            int sleep = (int) (Math.random() * 10) * 1000;
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println("Interrupted " + e);
        }
    }
}
