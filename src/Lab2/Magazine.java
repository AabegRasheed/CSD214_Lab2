package Lab2;

import java.util.Date;

public class Magazine extends Publication {
    private int orderQty;
    private Date currIssue;

    public Magazine(String title, double price, int copies, String ISBN10, int orderQty, Date currIssue) {
        super(title, price, copies, ISBN10);
        this.orderQty = orderQty;
        this.currIssue = currIssue;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Magazine: " + super.toString() + ", Order Quantity: " + orderQty + ", Current Issue: " + currIssue;
    }
}


