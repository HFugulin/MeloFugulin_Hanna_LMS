import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFunctionsTest {

    // Create an object to test
    Library library;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Supplying test data
        library = new Library();
        library.addBook(new Book("TestTitle1", "TestAuthor1", "111","TestGenre1"));
        library.addBook(new Book("TestTitle2", "TestAuthor2", "222", "TestGenre2"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing the addition of a Book.")
    void addBook_Test() {
        // Using the provided data, testing if books can be added to the database.
        Book newBook = new Book("TestTitle3", "TestAuthor3", "333", "TestGenre3");
        library.addBook(newBook);
        assertEquals(3, library.getBooks().size(), "Book count should be 3 after adding a book.");
        assertTrue(library.getBooks().contains(newBook), "Library should contain the newly added book.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing the removal of a Book by Barcode.")
    void removeBookByBarcode_Test() {
        // Using the provided data, testing if a book can be removed from the database by barcode
        boolean removed = library.removeBookByBarcode("111");
        assertTrue(removed, "Book with barcode '111' should have been removed.");
        assertEquals(1, library.getBooks().size(), "Book count should be 1 after removal.");
        assertFalse(library.getBooks().stream().anyMatch(book -> book.getBarcodeNumber().equals("111")), "Library should not have the removed book.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing the removal of a Book by Title.")
    void removeBookByTitle_Test() {
        // Using the provided data, testing if a book can be removed from the database by title
        boolean removed = library.removeBookByTitle("TestTitle2");
        assertTrue(removed, "Book with title 'TestTitle2' should be removed.");
        assertEquals(1, library.getBooks().size(), "Book count should be 1 after removal.");
        assertFalse(library.getBooks().stream().anyMatch(book -> book.getTitle().equals("TestTitle2")), "Library should not have the removed book.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing Checking Out a Book.")
    void checkOutBook_Test() {
        // Using the provided data, testing if a book can be checked out. If so, the due date is no longer "null".
        boolean checkedOut = library.checkOutBook("TestTitle1");
        assertTrue(checkedOut, "Book with title 'TestTitle1' should be checked out.");
        Book book = library.getBooks().stream().filter(b -> b.getTitle().equals("TestTitle1")).findFirst().orElse(null);
        assertNotNull(book, "Book with title 'TestTitle1' should exist in the library.");
        assertEquals("checked out", book.getStatus(), "Book status should be 'checked out'.");
        assertNotNull(book.getDueDate(), "Book due date should not be null after checking out.");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Testing Checking In a Book.")
    void checkInBook_Test() {
        // Using the provided data, testing if a book can be checked in. If so, the due date is "null".
        library.checkOutBook("TestTitle1"); // Need to check out the book before checking it back in.
        boolean checkedIn = library.checkInBook("TestTitle1");
        assertTrue(checkedIn, "Book with title 'TestTitle1' should be checked in.");
        Book book = library.getBooks().stream().filter(b -> b.getTitle().equals("TestTitle1")).findFirst().orElse(null);
        assertNotNull(book, "Book with title 'TestTitle1' should exist in the library.");
        assertEquals("checked in", book.getStatus(), "Book status should be 'checked in'.");
        assertNull(book.getDueDate(), "Book due date should be null after checking in.");
    }
}