// Hanna Melo Fugulin, 202430-CEN-3024C-33022, May 15 2024
// BOOK CLASS - Defines and initializes book attributes.

public class Book {
    int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}
