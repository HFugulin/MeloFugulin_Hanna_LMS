// Hanna Melo Fugulin - June 06th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis
// Serves as MAIN class. Program objective: a library management system application for a local library.
// The system must hold information for each book in the library’s collection and the user should be able to
// add, remove, check in, and check out books, as well as print the database.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Ask user for a file name and read books from the file
        // For testing: insert src/books.txt
        System.out.print("Enter the file name to load books: ");
        String fileName = scanner.nextLine();
        loadBooksFromFile(fileName, library);

        // Menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Display all books");
            System.out.println("2. Remove a book by barcode");
            System.out.println("3. Remove a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Check in a book");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Printing current library collection...");
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the barcode number of the book to remove: ");
                    String barcodeToRemove = scanner.nextLine();
                    if (library.removeBookByBarcode(barcodeToRemove)) {
                        System.out.println("Book removed successfully.");
                        library.displayBooks();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    if (library.removeBookByTitle(titleToRemove)) {
                        System.out.println("Book removed successfully.");
                        library.displayBooks();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title of the book to check out: ");
                    String titleToCheckOut = scanner.nextLine();
                    if (library.checkOutBook(titleToCheckOut)) {
                        System.out.println("Book checked out successfully.");
                        library.displayBooks();
                    } else {
                        System.out.println("Book not available or already checked out.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the title of the book to check in: ");
                    String titleToCheckIn = scanner.nextLine();
                    if (library.checkInBook(titleToCheckIn)) {
                        System.out.println("Book checked in successfully.");
                        library.displayBooks();
                    } else {
                        System.out.println("Book not found or already checked in.");
                    }
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose an option from 1 to 6.");
            }
        }

        scanner.close();
    }

     // Loads books from a file and adds them to the library.
     // fileName is the name of the file containing book information - will later be a database (current: src/books.txt).
     // library is The library to add books to.

    private static void loadBooksFromFile(String fileName, Library library) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length == 4) {
                    Book book = new Book(bookData[0], bookData[1], bookData[2], bookData[3]);
                    library.addBook(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
