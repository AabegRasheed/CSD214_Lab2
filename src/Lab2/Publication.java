package Lab2;

import java.io.Serializable;

public abstract class Publication implements SaleableItem, Serializable {
    protected String title;
    protected double price;
    protected int copies;
    protected String ISBN10;

    public Publication(String title, double price, int copies, String ISBN10) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.ISBN10 = ISBN10;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void sellCopy() {
        if (copies > 0) {
            copies--;
            System.out.println("Sold one copy of " + title);
        } else {
            System.out.println("No copies left for " + title);
        }
    }

    @Override
    public String toString() {
        return title + " [Price: " + price + ", Copies: " + copies + ", ISBN10: " + ISBN10 + "]";
    }
}

