package com.example.demo.dto;

import com.example.demo.domain.Book;
import com.example.demo.util.CustomBeanUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDTO {
//    private Long id;
    @NotBlank
    private String author;
    @Length(max=20)
    private String description;
    @NotBlank
    private String name;
    @NotNull
    private Integer status;
    public BookDTO(){

    }

//    @Override
//    public String toString() {
//        return "BookDTO{" +
//                "id=" + id +
//                ", author='" + author + '\'' +
//                ", description='" + description + '\'' +
//                ", name='" + name + '\'' +
//                ", status=" + status +
//                '}';
//    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public void convertToBook(Book book){
        new BookConvert().convert(this, book);
    }
    public Book convertToBook(){

        return new BookConvert().convert(this);
    }
    private class BookConvert implements Convert<BookDTO, Book>{

        @Override
        public Book convert(BookDTO bookDTO, Book book) {
            String[] nullPropertyNames = new CustomBeanUtils().getNullPropertyNames(bookDTO);
            BeanUtils.copyProperties(bookDTO, book,nullPropertyNames);
            return book;
        }

        @Override
        public Book convert(BookDTO bookDTO) {
            Book book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            return book;
        }
    }
}
