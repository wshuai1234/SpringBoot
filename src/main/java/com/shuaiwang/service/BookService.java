package com.shuaiwang.service;

import com.shuaiwang.domain.Book;

import java.util.Optional;

public interface BookService {
    Book getBookById(Long id);
}
