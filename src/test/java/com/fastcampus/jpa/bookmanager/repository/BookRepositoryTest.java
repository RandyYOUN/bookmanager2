package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.domain.Review;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest(){
        Book book = new Book();
        book.setName("테스트책 1");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);
        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();

        User user = userRepository.findByEmail("yhd0626@gmail.com");
    }


    @Test
    void bookCascadeTest(){
        Book book = new Book();
        book.setName("JPA초격차 패키지");

        //bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");
        //publisherRepository.save(publisher);

        book.setPublisher(publisher);
        bookRepository.save(book);

        //publisher.getBooks().add(book);
        //위는 동작은 하지만 가독성이 떨어져 아래처럼 사용하는게 최근 트랜드임.
//        publisher.addBook(book);
//        publisherRepository.save(publisher);

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("publishers : " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).get();
        book1.getPublisher().setName("슬로우캠퍼스");
        bookRepository.save(book1);

        System.out.println("publishers : "  + publisherRepository.findAll());

    }

    private void givenBookAndReview(){
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private User givenUser(){
        return userRepository.findByEmail("yhd0626@gmail.com");
    }

    private Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("JPA초격차패키지!!!1234");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private void givenReview(User user, Book book){
        Review review = new Review();
        review.setTitle("내 인생을 바꾼책");
        review.setContent("재미있는 책이였습니다.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        return publisherRepository.save(publisher);
    }
}
