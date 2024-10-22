package Lab2;

public class Book extends Publication {
    private String author;

    public Book(String title, double price, int copies, String ISBN10, String author) {
        super(title, price, copies, ISBN10);
        this.author = author;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Book: " + super.toString() + ", Author: " + author;
    }
}


