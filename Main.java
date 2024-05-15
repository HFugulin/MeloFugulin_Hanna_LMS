// Hanna Melo Fugulin, 202430-CEN-3024C-33022, May 15 2024
// MAIN CLASS - The user will be presented with a menu of options. Each option correlates to a method defined in the
// library class. They can check the list, add, and remove entries.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        // books.txt is a file present in the src folder, containing book entries with the specified formatting.
        // this is parsing through all lines in that file and separating (using commas) the ID, title, and author,
        // adding the separated entries to the library.
        try (BufferedReader reader = new BufferedReader(new FileReader("src/books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                Book book = new Book(id, title, author);
                library.addBook(book);
            }
        } catch (IOException e) {
            System.out.println("Error reading books data. Please ensure the file is accessible.");
            e.printStackTrace();
        }

        // printing a menu to aid usability. The user will call on methods by selecting an option from the menu.
        // the prompt will loop until the user presses 4. Errors take the user back to the menu.
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Add a book");
            System.out.println("2. Delete a book");
            System.out.println("3. Print the current list of books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        // Add a book - collects user input for ID (int), Title (str), and Author (str), adds to library.
                        System.out.print("Enter book ID (only integers): ");
                        int id = Integer.parseInt(br.readLine());
                        System.out.print("Enter book title (exactly as you want it to appear): ");
                        String title = br.readLine();
                        System.out.print("Enter book author (exactly as you want it to appear): ");
                        String author = br.readLine();
                        library.addBook(new Book(id, title, author));
                        break;
                    case 2:
                        // Delete a book - asks user for book ID to delete, if it finds it, it deletes it, if not,
                        // it informs the user and asks again.
                        System.out.print("Enter ID of the book you wish to delete: ");
                        int bookIdToRemove = Integer.parseInt(br.readLine());
                        if (library.removeBook(bookIdToRemove)) {
                            System.out.println("Book with ID " + bookIdToRemove + " has been removed successfully.");
                        } else {
                            System.out.println("Book with ID " + bookIdToRemove + " was not found.");
                        }
                        break;
                    case 3:
                        // Print current list of books in the library.
                        System.out.println("All books in the library: ");
                        library.listBooks();
                        break;
                    case 4:
                        // Exits the program by changing the predefined boolean exit to true.
                        exit = true;
                        System.out.println("Exiting the program. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (IOException e) {
                System.out.println("Invalid input. Please try again.");
            } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        }
    }
}
