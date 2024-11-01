package com.example.android_backend.service;

import com.example.android_backend.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book create(Book book);
}
