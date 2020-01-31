package com.shuaiwang.service;


import com.shuaiwang.domain.Book;
import com.shuaiwang.domain.BookRepository;
import com.shuaiwang.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book getBookById(Long id){
        Optional<Book> o = bookRepository.findById(id);
        if (! o.isPresent()){
            throw new BookNotFoundException("书单不存在");
        }
        Book book = bookRepository.findById(id).get();
       return book;
    }
}
