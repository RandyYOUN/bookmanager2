package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest(){
        System.out.println (entityManager.createQuery("select  u from User u").getResultList());

    }

    @Test
    void cacheFindTest(){
//
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findById(1L).get());
//        System.out.println(userRepository.findByEmail("yhd0626@gmail.com"));
//        System.out.println(userRepository.findByEmail("yhd0626@gmail.com"));
        System.out.println("------------------------------------------------------");
        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2(){
        User user = userRepository.findById(1L).get();
        user.setName("jhd02120626");

        userRepository.save(user);
        System.out.println("------------------------------------------------------");
        user.setEmail("jhd02120626@gmail.com");

        userRepository.save(user);
        //userRepository.flush();

        System.out.println(userRepository.findAll());
    }
}
