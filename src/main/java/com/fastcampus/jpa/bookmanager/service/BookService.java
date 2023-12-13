package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional(rollbackFor = Exception.class)
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA시작하기");

        bookRepository.save(book);

        Author author =  new Author();
        author.setName("yhd0626");
        authorRepository.save(author);

        throw new RuntimeException("오류발생!! rollback!!!!");
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void get(Long id){
        System.out.println(">>>>>>>>>>>>"+bookRepository.findById(id));
        System.out.println(">>>>>>>>>>>>"+bookRepository.findAll());

        System.out.println(">>>>>>>>>>>>"+bookRepository.findById(id));
        System.out.println(">>>>>>>>>>>>"+bookRepository.findAll());

        Book book = bookRepository.findById(id).get();
        book.setName("바뀔까?????????");
        bookRepository.save(book);
    }
}
