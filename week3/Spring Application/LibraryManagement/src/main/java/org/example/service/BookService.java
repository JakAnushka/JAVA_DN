package org.example.service;

import org.example.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository;

    // Setter for Spring XML injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Inside BookService...");
        bookRepository.fetchBooks();
    }
}
