package Lab2;

public class Ticket extends Publication {
    private String description;

    public Ticket(String description, double price, int copies, String ISBN10) {
        super(description, price, copies, ISBN10);
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void sellCopy() {
        if (copies > 0) {
            copies--;
            System.out.println("Sold one ticket: " + description);
        } else {
            System.out.println("No tickets left for " + description);
        }
    }

    @Override
    public String toString() {
        return "Ticket: " + description + ", Price: " + price;
    }
}



