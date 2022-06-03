package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test(){
        User user = new User();
        user.setEmail("yhd0626@gmail.com");
        user.setName("y2509g");
        user.setCreateAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
/*
        User user1 = User.builder()
                .name("y2509g2")
                .email("y2509g@nate.com")
                .createAt(LocalDateTime.now())
                .build();
*/
        //User user1 = new User(null,"y2509g","y2509g@nate.com",LocalDateTime.now(),LocalDateTime.now());
        User user2 = new User("yhd0626","yhd0626@gmail.com");

        User user3 = User.builder()
                .name("y2509g2")
                .email("y2509g2@nate.com")
                .build();

        System.out.println("2>>> : " + user.toString());
    }
}