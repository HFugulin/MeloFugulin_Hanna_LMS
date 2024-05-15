// Hanna Melo Fugulin, 202430-CEN-3024C-33022, May 15 2024
// LIBRARY CLASS - Initializes empty library and defines Add, Remove, and List methods.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Library {
    private List<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    // addBook - adds new book entry to book list.
    public void addBook(Book book) {
        books.add(book);
    }
    // removeBook - iterates through list, finds book ID that matches the user's input, and removes it.
    public boolean removeBook(int bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.id == bookId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    // listBooks - Iterates through entire list and prints it.
    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
