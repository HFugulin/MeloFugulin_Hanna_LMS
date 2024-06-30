// Hanna Melo Fugulin - June 29th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis
// This class extends JFrame to create the main window of the GUI that makes the LMS user-friendly.
// It allows users to load books from a file, display the book list, remove books by barcode or title, and check in/check out books.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibraryGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JTextField fileNameField;
    private JButton loadButton;
    private JTextArea bookListArea;
    private JTextField barcodeField;
    private JButton removeByBarcodeButton;
    private JTextField titleField;
    private JButton removeByTitleButton;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JButton exitButton;
    private Library library;

    public LibraryGUI() {
        library = new Library();
        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(820, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Load books from file
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                loadBooksFromFile(fileName);
                displayBooks();
            }
        });

        // Remove book by barcode
        removeByBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = barcodeField.getText();
                if (library.removeBookByBarcode(barcode)) {
                    JOptionPane.showMessageDialog(null, "Book removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
                displayBooks();
            }
        });

        // Remove book by title
        removeByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (library.removeBookByTitle(title)) {
                    JOptionPane.showMessageDialog(null, "Book removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
                displayBooks();
            }
        });

        // Check out book
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (library.checkOutBook(title)) {
                    JOptionPane.showMessageDialog(null, "Book checked out successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not available or already checked out.");
                }
                displayBooks();
            }
        });

        // Check in book
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (library.checkInBook(title)) {
                    JOptionPane.showMessageDialog(null, "Book checked in successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found or already checked in.");
                }
                displayBooks();
            }
        });

        // Exit the program
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exiting the Library Management System. Goodbye!");
                System.exit(0);
            }
        });
    }

    // Loads books from the file and adds them to the library.
    // @param fileName The name of the file containing book information (currently using books.txt)

    private void loadBooksFromFile(String fileName) {
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
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }


    // Displays the list of books in the library in the text area.
    private void displayBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book book : library.getBooks()) {
            sb.append(book.toString()).append("\n");
        }
        bookListArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}