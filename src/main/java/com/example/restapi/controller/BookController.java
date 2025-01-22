package com.example.restapi.controller;

import com.example.restapi.model.Book;
import com.example.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restapi.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        System.out.println(book);
        if(book.isEmpty()){
            System.out.print("No book is there in the database");
        }
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findByAuthor")
    public List<Book> greetUser(@RequestParam String AuthorName) {
        List<Book> books = bookService.getBooksByAuthorName(AuthorName);
        return books;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
//        Optional<Book> book = bookService.getBookById(id);
//        updates.forEach((key, value) -> {
//            switch (key) {
//                case "title":
//                    book.setTitle((String) value);
//                    break;
//                case "author":
//                    book.setAuthor((String) value);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Invalid field: " + key);
//            }
//        });
//
//        // Save the updated book
//        BookRepository.save(book);
//        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @PatchMapping("/{id}")
    public Book updateUser(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}