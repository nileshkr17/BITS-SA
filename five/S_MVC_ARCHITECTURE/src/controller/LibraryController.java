

package controller;

import model.Book;
import model.LibraryModel;
import view.LibraryView;

public class LibraryController {
    private LibraryModel model;
    private LibraryView view;

    public LibraryController(LibraryModel model, LibraryView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean running = true;
        while (running) {
            int choice = view.showMenuAndGetChoice();
            switch (choice) {
                case 1:
                    // Add a new book
                    Book book = view.getBookDetails();
                    model.addBook(book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    // View all books
                    view.displayAllBooks(model.getAllBooks());
                    break;
                case 3:
                    // Search for a book by title
                    System.out.print("Enter title to search: ");
                    view.scanner.nextLine(); // Consume newline
                    String title = view.scanner.nextLine();
                    Book foundBook = model.searchBookByTitle(title);
                    view.displaySearchResult(foundBook);
                    break;
                case 4:
                    // Update book details
                    Book updatedBook = view.getUpdatedBookDetails();
                    boolean updated = model.updateBook(updatedBook.getId(), updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getPrice());
                    if (updated) {
                        System.out.println("Book updated successfully.");
                    } else {
                        System.out.println("Book not found. Update failed.");
                    }
                    break;
                case 5:
                    // Delete a book
                    System.out.println("List of all books:");
                    //check if the list is empty before deleting
                    if (model.getAllBooks().isEmpty()) {
                        System.out.println("No books to delete.");
                        break;
                    }
                    view.displayAllBooks(model.getAllBooks());
                    int bookIdToDelete = view.getBookIdToDelete();
                    boolean deleted = model.deleteBook(bookIdToDelete);
                    if (deleted) {
                        System.out.println("Book deleted successfully.");
                        if(model.getAllBooks().isEmpty()) {
                            System.out.println("No books left in the library.");
                        }else {
                            System.out.println("List of remaining books:");
                            view.displayAllBooks(model.getAllBooks());
                        }
                    } else {
                        System.out.println("Book not found. Deletion failed.");
                    }
                    break;
                case 6:
                    // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
