package Test;

import Lab2.Book;
import Lab2.Main;
import Lab2.SaleableItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Main bookstore;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        bookstore = new Main();
        book1 = new Book("Test Book 1", 10.99, 5, "1234567890", "Author 1");
        book2 = new Book("Test Book 2", 15.99, 3, "0987654321", "Author 2");
        bookstore.getSaleableItems().add(book1);
        bookstore.getSaleableItems().add(book2);
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("New Test Book", 12.99, 10, "1231231231", "Author 3");
        bookstore.getSaleableItems().add(newBook);
        assertTrue(bookstore.getSaleableItems().contains(newBook), "Book should be added to the bookstore");
    }

    @Test
    void testEditBookTitle() {
        SaleableItem item = bookstore.getSaleableItems().get(0);
        assertTrue(item instanceof Book, "The first item should be a Book");
        Book existingBook = (Book) item;
        existingBook.setTitle("Updated Title");
        assertEquals("Updated Title", ((Book) bookstore.getSaleableItems().get(0)).getTitle(), "Book title should be updated");
    }

    @Test
    void testDeleteBook() {
        SaleableItem item = bookstore.getSaleableItems().get(0);
        assertTrue(item instanceof Book, "The first item should be a Book");
        Book existingBook = (Book) item;
        bookstore.getSaleableItems().remove(existingBook);
        assertFalse(bookstore.getSaleableItems().contains(existingBook), "Book should be removed from the bookstore");
    }

    @Test
    void testDeleteBookByIndex() {
        bookstore.getSaleableItems().remove(1);
        assertEquals(1, bookstore.getSaleableItems().size(), "Book list size should decrease after deletion");
    }
}
