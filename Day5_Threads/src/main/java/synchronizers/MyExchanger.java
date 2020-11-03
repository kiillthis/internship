package synchronizers;

import java.util.concurrent.Exchanger;

public class MyExchanger {

    public static void main(String[] args) {

        Exchanger<String> exgr = new Exchanger<String>();

        new MakeString(exgr);
        new UseString(exgr);
    }
}

class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    public MakeString(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();
        new Thread(this).start();
    }

    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }

            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(ex);
            }
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    public UseString(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Получено: " +  str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
