package com.example.demo.api;
import com.example.demo.domain.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.BookService;
import com.example.demo.util.CustomBeanUtils;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BookApi {
    @Autowired
    private BookService bookService;
    //获取书单列表
    @GetMapping("/books")
    public ResponseEntity<?> listAllBooks(){
        List<Book> books =  bookService.findAllBooks();
        if(books.isEmpty()){
            throw new NotFoundException("书单列表不存在");
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    //获取一个书单
    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if(book == null){
            throw new NotFoundException(String.format("book by id %s not found", id));
        }
        return new ResponseEntity<Object>(book, HttpStatus.OK);
    }
    //新增一条书单
    @PostMapping("/books")
    public ResponseEntity<?> saveBook(@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter", bindingResult);
        }
        Book book1 = bookService.saveBook(bookDTO.convertToBook());
        return new ResponseEntity<Object>(book1, HttpStatus.CREATED);
    }
    //更新一条书单
    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id,@Valid @RequestBody BookDTO bookDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new InvalidRequestException("Invalid parameter", bindingResult);
        }
        Book currentBook = bookService.getBookById(id);
        //BeanUtils.copyProperties(bookDTO,currentBook);
        if (currentBook == null){
            throw new NotFoundException(String.format("Book by Id %s not found", id));
        }
        bookDTO.convertToBook(currentBook);
        Book book1 = bookService.saveBook(currentBook);
        return new ResponseEntity<Object>(book1, HttpStatus.OK);
    }
    //删除一条书单
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
    //删除所有书单
    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }


}
