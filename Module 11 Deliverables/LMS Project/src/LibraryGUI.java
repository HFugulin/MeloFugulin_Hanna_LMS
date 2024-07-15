// Hanna Melo Fugulin - July 7th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis

/**
 * This class extends JFrame to create the main window of the GUI that makes the LMS user-friendly.
 * It allows users to load books from a file, display the book list, remove books by barcode or title, and check in/check out books.
 */
import DBHelper.BooksLMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;


public class LibraryGUI extends JFrame {
    public static final String CHECKED_IN = "checked in";
    public static final String TITLE = "Title";
    public static final String STATUS = "Status";
    public static final String ALL_COLS = "Title, Author, Barcode, Genre, Status, DueDate";
    public static final String BARCODE = "Barcode";
    public static final String CHECKED_OUT = "checked out";
    public static final String DUE_DATE = "DueDate";
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JTextArea bookListArea;
    private JTextField barcodeField;
    private JButton removeByBarcodeButton;
    private JTextField titleField;
    private JButton removeByTitleButton;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JButton exitButton;
    private Library library;
    private BooksLMS database;

    /**
     * Constructor to initialize the GUI and set up action listeners.
     */
    public LibraryGUI() {
        library = new Library();
        database = new BooksLMS();

        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(820, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loadBooks();
        displayBooks();

        // Remove book by barcode
        removeByBarcodeButton.addActionListener(new ActionListener() {
            /**
             * Action performed when remove by barcode button is clicked.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = barcodeField.getText();
                if (library.removeBookByBarcode(barcode)) {
                    database.delete(BARCODE, "\"" + barcode + "\"");
                    JOptionPane.showMessageDialog(null, "Book removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
                displayBooks();
            }
        });

        // Remove book by title
        removeByTitleButton.addActionListener(new ActionListener() {
            /**
             * Action performed when remove by title button is clicked.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (library.removeBookByTitle(title)) {
                    database.delete(TITLE, "\"" + title + "\"");
                    JOptionPane.showMessageDialog(null, "Book removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
                displayBooks();
            }
        });

        // Check out book
        checkOutButton.addActionListener(new ActionListener() {
            /**
             * Action performed when check out button is clicked.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (library.checkOutBook(title)) {
                    database.update(STATUS, prepareStringValue(CHECKED_OUT), TITLE, prepareStringValue(title));
                    database.update(DUE_DATE, prepareStringValue(String.valueOf(LocalDate.now().plusWeeks(4))), TITLE, prepareStringValue(title));
                    JOptionPane.showMessageDialog(null, "Book checked out successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not available or already checked out.");
                }
                displayBooks();
            }
        });

        // Check in book
        checkInButton.addActionListener(new ActionListener() {
            /**
             * Action performed when check in button is clicked.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (library.checkInBook(title)) {
                    database.update(STATUS, prepareStringValue(CHECKED_IN), TITLE, prepareStringValue(title));
                    database.update(DUE_DATE, "NULL", TITLE, prepareStringValue(title));
                    JOptionPane.showMessageDialog(null, "Book checked in successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found or already checked in.");
                }
                displayBooks();
            }
        });

        // Exit the program
        exitButton.addActionListener(new ActionListener() {
            /**
             * Action performed when exit button is clicked.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exiting the Library Management System. Goodbye!");
                System.exit(0);
            }
        });
    }
    /**
     * Loads books from the database and adds them to the library.
     */
    private void loadBooks() {
        ArrayList<ArrayList<Object>> bookList = database.select(ALL_COLS, null, null, null, null);

        for (ArrayList<Object> bookData: bookList) {
            if (bookData.size() == 6) {
                Book book = new Book(
                        bookData.get(0).toString(),
                        bookData.get(1).toString(),
                        bookData.get(2).toString(),
                        bookData.get(3).toString(),
                        bookData.get(4).toString(),
                        bookData.get(5) == null ? null : bookData.get(5).toString()
                );
                library.addBook(book);
            }
        }
    }

    /**
     * Prepares a string value for SQL queries by adding double quotes.
     *
     * @param str the string to prepare
     * @return the prepared string
     */
    private String prepareStringValue(String str){
        return "\"" + str + "\"";
    }

    /**
     * Displays the list of books in the library in the text area.
     */
    private void displayBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book book : library.getBooks()) {
            sb.append(book.toString()).append("\n");
        }
        bookListArea.setText(sb.toString());
    }
    /**
     * The main method to run the LibraryGUI application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new LibraryGUI();
    }
}
