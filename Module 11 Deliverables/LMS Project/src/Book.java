// Hanna Melo Fugulin - July 7th 2024 - CEN-3024C-33022
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

    /**
     * @param title
     * @param author
     * @param barcodeNumber
     * @param genre
     * @param status
     * @param dueDate
     */
    // Constructor
    public Book(String title, String author, String barcodeNumber, String genre, String status, String dueDate) {
        this.title = title;
        this.author = author;
        this.barcodeNumber = barcodeNumber;
        this.genre = genre;
        this.status = status;
        this.dueDate = dueDate;
    }

    /**
     * @return
     */
    // Getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    /**
     * @return
     */
    public String getBarcodeNumber() { return barcodeNumber; }
    public String getGenre() { return genre; }

    /**
     * @return
     */
    public String getStatus() { return status; }

    /**
     * @return
     */
    public String getDueDate() { return dueDate; }

    /**
     * @param status
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * @param dueDate
     */
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    /**
     * @return
     */
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Barcode: %s, Genre: %s, Status: %s, Due Date: %s",
                title, author, barcodeNumber, genre, status, dueDate);
    }
}