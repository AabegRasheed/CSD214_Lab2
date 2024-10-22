package Lab2;

public class Pencil implements SaleableItem {
    private double price;

    public Pencil(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void sellCopy() {
        System.out.println("Pencil sold.");
    }

    @Override
    public String toString() {
        return "Pencil [Price: " + price + "]";
    }
}
