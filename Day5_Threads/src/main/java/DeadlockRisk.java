public class DeadlockRisk implements Runnable {
    private static class Resource {

    }

    private final Resource scissors = new Resource();
    private final Resource paper = new Resource();

    public void doSun() {
        synchronized (scissors) {
            System.out.println(Thread.currentThread().getName() + " взяла ножницы для вырезания солнышка");

            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " взяла бумагу для солнышка");

                System.out.println(Thread.currentThread().getName() + " вырезает солнышко");
            }
        }
    }

    public void doCloud() {
        synchronized (paper) {
            System.out.println(Thread.currentThread().getName() + " взяла бумагу для вырезания облаков");
            synchronized (scissors) {
                System.out.println(Thread.currentThread().getName() + " взяла бумагу для облаков");
                System.out.println(Thread.currentThread().getName() + " вырезает облака");
            }
        }
    }

    public void run() {
        doSun();
        doCloud();
    }

    public static void main(String[] args) {
        DeadlockRisk job = new DeadlockRisk();
        Thread masha = new Thread(job, "Маша");
        Thread sasha = new Thread(job, "Саша");

        masha.start();
        sasha.start();
    }
}
