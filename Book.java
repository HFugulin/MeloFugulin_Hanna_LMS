// Hanna Melo Fugulin - June 06th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis
// Represents a book in the library system.
// Each book has a title, author, barcode number, genre, status, and due date.

import java.time.LocalDate;
public class Book {
    private String title;
    private String author;
    private String barcodeNumber;
    private String genre;
    private String status; // "checked in" or "checked out"
    private String dueDate;

    // Constructor
    public Book(String title, String author, String barcodeNumber, String genre) {
        this.title = title;
        this.author = author;
        this.barcodeNumber = barcodeNumber;
        this.genre = genre;
        this.status = "checked in";
        this.dueDate = null;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getBarcodeNumber() { return barcodeNumber; }
    public String getGenre() { return genre; }
    public String getStatus() { return status; }
    public String getDueDate() { return dueDate; }

    public void setStatus(String status) { this.status = status; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Barcode: %s, Genre: %s, Status: %s, Due Date: %s",
                title, author, barcodeNumber, genre, status, dueDate);
    }
}
