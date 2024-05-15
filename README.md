# MeloFugulin_Hanna_LMS
Module 2 | SDLC Assignment 

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
