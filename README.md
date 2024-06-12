# MeloFugulin_Hanna_LMS

# Module 6 Updates: 

To start implementing the first phase of the Library Management System (LMS), the code was structured into three main classes:

- Book.java: Defines the Book class with attributes and methods for a book object.
- Library.java: Manages the collection of Book objects and provides methods for adding, removing, checking out, checking in, and displaying books.
- LibraryApp.java: Contains the main method, which interacts with the user to perform the required tasks.

## The main method executes the following tasks: 

1. Ask the user for a file name, and receive it from the user.  Open the file supplied by the user, and add each book to the LMS database.
2. Print the database to the screen, with a short message indicating that printing is taking place.
3. Ask the user for a barcode number to remove.  Receive the barcode, remove the corresponding book from the database, print a confirmation message that the book was deleted, and re-print the contents of the database to the screen.
4. Ask the user for a title number to remove.  Receive the title, remove the corresponding book from the database, print a confirmation message that the book was deleted, and re-print the contents of the database to the screen.
5. Ask the user for a title to check out. Check out the book, print a confirmation message, and re-print the contents of the database to the screen.
6. Ask the user for a title to check in. Check in the book, print a confirmation message, and re-print the contents of the database to the screen.

 - Menu Loop: The program includes a loop that repeatedly displays a menu to the user. The user can choose an option by entering a number.
 - Switch Case: Based on the user's choice, the corresponding action is performed (display all books, remove a book by barcode, remove a book by title, check out a book, check in a book, or exit the program).
 - Exit Condition: The loop continues until the user selects the option to exit (case 6), at which point the program prints a goodbye message and terminates.


# (Previous Content) 
# Module 2 | SDLC Assignment 

## Defining Requirements
This Library Management System will be a console-based application for managing a library's collection of books. There are three main features for this LMS: 
1.	Adding new books to the collection from a text file (each book has a unique ID number, title, and author)
a.	The text file should be formatted with each line representing a book. The id, title, and author are separated by a comma. (i.e 1,To Kill a Mockingbird,Harper Lee)
2.	Removing a book from the collection using its ID number
3.	Listing all books currently in the collection
As this LMS main users will be librarians (or library staff), the user must be able to quickly access, manage, and manipulate the system. 


## Gathering Requirements
As previously mentioned, the intended users of the LMS are librarians or library staff members who need to manage and access the library's collection. 
They would interact with the system through command-line prompts or menu, and they must be able to quickly choose which feature (add, remove, list) they want to do, and once they perform an action, they must be prompted again until they choose to exit the program, so they can quickly perform multiple actions without needing to restart it.
The LMS must be simple to operate, with as intuitive of an interface as possible. It should uphold POUR values (perceivable, operable, understanding, and robust).

## Implementation Plan
The three main features can be broken down as classes and methods:
Book class – Attributes: ID (int), Title (Str), Author (Str). Methods: Constructor (initialize the attributes), and a method to return the string with the indicated format.
Library class – Attributes: Books (list, stores book objects). Methods: Constructor (initialize the empty library), then Add, Remove, and List methods.
Algorithms: Add (reads text file data, splits lines into attributes, creates a new book object, adds the object to the collection), Remove (iterates through the collection, finds book with specified ID, removes the book from the collection), List (iterates through the collection, prints the string for all books).
**Main class: will display a menu of options. Each option correlates to a method defined in the library class. User can check the list, add, and remove entries by interacting with the prompts on the menu. Loops until voluntary exit.

## Testing Plan
To ensure the code runs smoothly, each method will be individually tested to ensure they work as expected, including both cases that should work and that should not work (i.e incorrect formatting). 
Once it is confirmed that each class and method work individually, the program and its integration/interaction between classes and methods will be tested, so that the overall functionality of the program can be assessed.
If this program were to be released and utilized by actual library systems, and there was a pool of testers available, there would also be librarians or potential users authentically trying the program out to test the system and provide feedback both on usability and effectiveness.
** THIS IS OUTSIDE SCOPE OF PROJECT, but after using it, here’s the feedback I’d implement in the future: adding an ‘edit’ feature, so the user can change ID, Title, or Author name. Also further implementation for navigation would be nice (i.e press 1 to return to menu, so on and so forth). For a simple, command interface, it’s fine as is. Would probably be best to set a database for this project rather than utilizing a text file, but that’s not what I was asked to do.
