package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Modifying
    @Query(value = "UPDATE book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();
    List<Book> findByCategoryIsNullAndDeletedFalse();
    List<Book> findByCategoryIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtGreaterThanEqual(String name , LocalDateTime createAt, LocalDateTime updateAt);

    @Query(value = "select b from Book b "
        + "where name = :name and createAt >= :createAt and updateAt >= :updateAt and category is null"
    )
    List<Book> findbyNameRecently(
            @Param("name") String name,
            @Param("createAt") LocalDateTime createAt,
            @Param("updateAt") LocalDateTime updateAt);

    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory( b.name , b.category ) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory( b.name , b.category ) from Book b")
    Page<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);
}
