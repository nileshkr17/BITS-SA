package model;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel {
    private List<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    // Update a book
    public boolean updateBook(int id, String title, String author, double price) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                return true;
            }
        }
        return false; // Book not found for update
    }
    // Delete a book
   // Delete a book by ID
   
   public boolean deleteBook(int id) {
    return books.removeIf(book -> book.getId() == id);
}


}
