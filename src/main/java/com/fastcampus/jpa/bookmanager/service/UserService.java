package com.fastcampus.jpa.bookmanager.service;
import  com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@gmail.com");

        //userRepository.save(user);
        entityManager.persist(user);
//        entityManager.detach(user);
        //detach말고도 clear나 close도 사용가능.

        user.setName("newUserAfterPersist");
        entityManager.merge(user);
        //userRepository.save(user);
        //userRepository 사용해 save하지 않더라도 Transaction이 종료되는시점에 자동으로 저장이됨.
//        entityManager.flush(); // flush가 없으면 clear때문에 저장되지 않는다
//        entityManager.clear();

        //ntityManager.remove(user);

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("marrrrrrrrrrrtin");
        entityManager.merge(user1);
    }
}
