// Hanna Melo Fugulin - June 06th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis
// Manages a collection of books in the library.
// Provides functionalities to add, remove, check out, check in, and display books.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

     // Adds a book to the library.
    public void addBook(Book book) {
        books.add(book);
    }

     // Removes a book by barcode number.
     // Returns True if the book was removed, false otherwise.
    public boolean removeBookByBarcode(String barcodeNumber) {
        return books.removeIf(book -> book.getBarcodeNumber().equals(barcodeNumber));
    }

     // Removes a book by title.
     // Returns True if the book was removed, false otherwise.
    public boolean removeBookByTitle(String title) {
        return books.removeIf(book -> book.getTitle().equals(title));
    }

     // Checks out a book by title.
     // Returns True if the book was checked out, false otherwise.
     public boolean checkOutBook(String title) {
         for (Book book : books) {
             if (book.getTitle().equals(title) && book.getStatus().equals("checked in")) {
                 book.setStatus("checked out");
                 book.setDueDate(String.valueOf(LocalDate.now().plusWeeks(4)));
                 return true;
             }
        }
        return false;
    }

    // Checks in a book by title.
    // Returns True if the book was checked in, false otherwise.
    public boolean checkInBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getStatus().equals("checked out")) {
                book.setStatus("checked in");
                book.setDueDate(null);
                return true;
            }
        }
        return false;
    }

// Displays all books in the library.

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
        // Returns the list of books in the library -- to make testing easier.
    public List<Book> getBooks() {
        return books;
    }
}
