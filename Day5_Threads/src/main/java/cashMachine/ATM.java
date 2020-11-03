package cashMachine;

public class ATM {
    private int account;

    public ATM(int account) {
        this.account = account;
    }

    public void takeMoney(int sum) {

        if (account - sum >= 0) {
            account -= sum;
            System.out.println("-" + sum);
        } else {
            throw new IllegalArgumentException("Недостаточно денег на счету");
        }

    }

    public int getAccount() {
        return account;
    }

}
