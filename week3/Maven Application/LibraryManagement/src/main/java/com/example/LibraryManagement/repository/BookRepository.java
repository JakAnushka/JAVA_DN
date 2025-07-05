package com.example.LibraryManagement.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void fetchBooks() {
        System.out.println("Fetching books from repository...");
    }
}
