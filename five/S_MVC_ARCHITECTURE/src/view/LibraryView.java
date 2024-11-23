

package view;

import model.Book;

import java.util.Scanner;

public class LibraryView {
    public Scanner scanner = new Scanner(System.in);

    // Show menu options
    public int showMenuAndGetChoice() {
        System.out.println("Library Menu:");
        System.out.println("1. Add a new book");
        System.out.println("2. View all books");
        System.out.println("3. Search for a book by title");
        System.out.println("4. Update book details");
        System.out.println("5. Delete a book");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }

    // Get book details from user
    public Book getBookDetails() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        return new Book(id, title, author, price);
    }

    // Display all books
    public void displayAllBooks(Iterable<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Display search result
    public void displaySearchResult(Book book) {
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Get book ID to delete
    public int getBookIdToDelete() {
        System.out.print("Enter the ID of the book to delete: ");
        return scanner.nextInt();
    }

    // Get book details to update
    public Book getUpdatedBookDetails() {
        System.out.print("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();
        return new Book(id, title, author, price);
    }
}
