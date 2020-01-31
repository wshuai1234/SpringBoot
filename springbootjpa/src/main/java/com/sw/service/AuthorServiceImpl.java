package com.sw.service;

import com.sw.domain.Author;
import com.sw.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Transactional
    @Override
    public Author updateAuthor(){
        Author author = new Author();
        author.setId((long)10);
        author.setPhone("4658971523");
        author.setNickName("yajie");
        author.setSignDate(new Date());
        Author author1 = authorRepository.save(author);

        author1.setPhone("3472053030");
        Author author2 = authorRepository.save(author1);
        return author2;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (! author.isPresent()){
            return null;
        }
        return author.get();
//        return authorRepository.findById(id);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
