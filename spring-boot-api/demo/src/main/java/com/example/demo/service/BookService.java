package com.example.demo.service;

import com.example.demo.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);
    void deleteAllBooks();
}
