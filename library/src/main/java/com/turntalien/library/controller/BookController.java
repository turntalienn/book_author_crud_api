package com.turntalien.library.controller;

import com.turntalien.library.entity.Book;
import com.turntalien.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("library")
@Validated
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/new_book")
    Book newBook(@Valid @RequestBody Book book){

        Book newBook = Book.builder()
                .bookName(book.getBookName())
                .publishedYear(book.getPublishedYear())
                .author(book.getAuthor())
                .build();

        service.addNewBook(newBook);

        return book;

    }

    @DeleteMapping("/delete_book")
    public void deleteBook(Long bookId) {

        service.DeleteById(bookId);

    }

    @PutMapping("/update_book/{bookId}")
    public void updateBook(@Valid @PathVariable Long bookId, @RequestBody Book book) {

            Book updatedBook = service.findById(bookId);
            updatedBook.setBookName(book.getBookName());
            updatedBook.setPublishedYear(book.getPublishedYear());
            updatedBook.setAuthor(book.getAuthor());

            service.saveBook(updatedBook);

    }

    @GetMapping("/find_book/{bookId}")
    public Book findBook(@PathVariable Long bookId) {

        return service.findById(bookId);

    }

    @GetMapping("/show_all")
    public List<Book> showAll() {

        return service.shoeAllBooks();

    }



}
