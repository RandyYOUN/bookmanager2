package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    //@Transactional
    @Test
    void crud(){
        //userRepository.save(new User());

        //System.out.println(">>>> " + userRepository.findAll());
        //userRepository.findAll().forEach(System.out::println);

        //List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        //List<User> users = userRepository.findAllById(Lists.newArrayList(1L,3L,5L));
        //User user1 = new User("jack","jack@gmail.com");
        //User user2 = new User("steve","steve@gmail.com");
        //User user1 = new User("jack","jack@gmail.com");
        //userRepository.save(user1);

        //List<User> users = userRepository.findAll();
        //users.forEach(System.out::println);
        //Optional<User> user =  userRepository.findById(1L);
        //User user =  userRepository.findById(1L).orElse(null);
        //System.out.println(user);

        //userRepository.saveAndFlush(new User("new martin","newmartin@gmail.com"));
        //userRepository.flush();
        //userRepository.findAll().forEach(System.out::println);

        //long count = userRepository.count();
        //System.out.println("count : " + count);

        //boolean exists = userRepository.existsById(1L);
        //System.out.println(exists);

        //userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        //userRepository.deleteById(1L);


        //userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));

        //serRepository.deleteAllInBatch();
        //userRepository.findAll().forEach(System.out::println);
/*
        Page<User> users = userRepository.findAll(PageRequest.of(0,2));

        System.out.println("page : "+ users);
        System.out.println("total count() : " + users.getTotalElements());
        System.out.println("total pages : " + users.getTotalPages());
        System.out.println("numberOfElements : "+ users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());

        users.getContent().forEach(System.out::println);
*/
/*
// Query : Like 검색 처리
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email",endsWith());
        Example<User> example = Example.of(new User("na" ,  "nate.com"),matcher);

 */
        // Query : 정확한 and 매칭 처리
        //Example<User> example = Example.of(new User("y2509g" ,  "y2509g@nate.com"));

        User user = new User();
        user.setEmail("yhd");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user,matcher);
        userRepository.findAll(example).forEach(System.out::println);

    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("james"));
//        System.out.println("findByEmail : " + userRepository.findByEmail("y2509g@nate.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("y2509g@nate.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("y2509g@nate.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("y2509g@nate.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("y2509g@nate.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("y2509g@nate.com"));
//
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("y2509g"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("y2509g"));
//
//        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("y2509g"));
        //System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("y2509g@nate.com","y2509g"));
        //System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("y2509g@nate.com","yhd0626"));
//        System.out.println("findByCreateAtAfter : " + userRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreateAtGreaterThan : " + userRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreateAtGreaterThanEqual : " + userRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//
        System.out.println("findByCreateAtBetween : " + userRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull() );
        //System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty() );

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("y2509g","yhf0")) );

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("yhd") );
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("626") );
        System.out.println("findByNameContains : " + userRepository.findByNameContains("2509") );
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%2%") );
    }

    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("y2509g") );
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("y2509g") );
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("y2509g") );
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("y2509g",Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))) );
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("y2509g", getSort()) );

        System.out.println("findByNameWithPaging : " + userRepository.findByName("y2509g", PageRequest.of(1,1,Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }

    private Sort getSort(){
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.asc("email"),
                Sort.Order.desc("createAt"),
                Sort.Order.asc("updateAt")

        );
    }

    @Test
    void insertAndUpdateTest(){
        User user = new User();
        user.setName("y2509g2");
        user.setEmail("y2509g2@korea.com");
        userRepository.save(user);
        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("leejh");
        userRepository.save(user2);
    }

    @Test
    void enumTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));

    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin@nate.com");
        user.setName("martin");
        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("martin2222222");

        userRepository.save(user2);
        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@naver.com");
//        user.setCreateAt(LocalDateTime.now());
//        user.setUpdateAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("y2509g@nate.com"));
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as - is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }


    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("martin@naver.com");
        user.setName("martin-new");
        userRepository.save(user);

        user.setName("martin-new-new");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("david");
        user.setEmail("david@naver.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@naver.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@naver.com")
//                        .getId()
//        );

        List<UserHistory> result = userRepository.findByEmail("daniel@naver.com").getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }
}













