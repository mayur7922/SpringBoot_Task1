package com.example.restapi.repository;
import com.example.restapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    List<Book> findByAuthorName(@Param("author") String authorName);
    List<Book> findByauthor(String author);
}