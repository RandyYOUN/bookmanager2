package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fastcampus.jpa.bookmanager.domain.Book;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void trasactionTest(){
        try{
            bookService.putBookAndAuthor();
            //bookService.put();

        }catch (RuntimeException e){
            System.out.println(">>>>>>>>>" + e.getMessage());
        }

        System.out.println("books : "+ bookRepository.findAll());
        System.out.println("author : " + authorRepository.findAll());

    }


    @Test
    void isolationTest(){
        Book book = new Book();

        book.setName("JPA 강의");
        bookRepository.save(book);

        bookService.get(1L);
        System.out.println(">>>>>>" + bookRepository.findAll());
    }


    @Test
    void converterErrorTest(){
        bookService.getAll();

        bookRepository.findAll().forEach(System.out::println);
    }
}