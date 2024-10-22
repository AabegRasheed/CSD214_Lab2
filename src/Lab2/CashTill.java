package Lab2;

public class CashTill {
    private static CashTill instance;
    private double runningTotal;

    private CashTill() {
        this.runningTotal = 0.0;
    }

    public static CashTill getInstance() {
        if (instance == null) {
            instance = new CashTill();
        }
        return instance;
    }

    public void addToTotal(double amount) {
        this.runningTotal += amount;
    }

    public double showTotal() {
        return this.runningTotal;
    }
}



