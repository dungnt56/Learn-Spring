package com.example.android_backend.controller;

import com.example.android_backend.model.Book;
import com.example.android_backend.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get-all-book")
    public List<Book> getAllBook() {
        return bookService.getAll();
    }

    @PostMapping("/create-book")
    public Book createBook(@RequestBody Book book) {
        return bookService.create(book);
    }
}
