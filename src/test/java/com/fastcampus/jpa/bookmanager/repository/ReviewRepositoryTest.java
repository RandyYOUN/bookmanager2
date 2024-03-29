package com.fastcampus.jpa.bookmanager.repository;


import com.fastcampus.jpa.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest(){
        List<Review> reviews = reviewRepository.findAll();
//        System.out.println(reviews);
//        List<Review> reviews = reviewRepository.findAllByFetchJoin();
//        System.out.println("=====================전체조회======================");
//
//        List<Review> reviews = reviewRepository.findAllByEntityGraph();
//        System.out.println(reviews.get(0).getComments());
//        System.out.println("첫번째 리뷰의 코멘트들을 가져왔습니다.");
//
//        System.out.println(reviews.get(1).getComments());
//        System.out.println("두번째 리뷰의 코멘트들을 가져왔습니다.");

    reviews.forEach(System.out::println);

    }
}
