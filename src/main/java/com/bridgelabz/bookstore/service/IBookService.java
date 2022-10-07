package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.model.BookData;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    String insert(BookDTO bookDTO);

    List<BookData> getAllBooks();

    Optional<BookData> getBooksById(int id);

    List<BookData> getBookByName(String bookName);

    List<BookData> getBookByAuthorName(String authorName);

    BookData updateBooksById(int id, BookDTO bookDTO);

    BookData updateBooksByQuantity(String token, int quantity);

    List<BookData> sortBookDataAsc();

    List<BookData> sortBookDataDesc();

    void deleteBookData(int id);
}