package com.turntalien.library.service;

import com.turntalien.library.entity.Book;
import com.turntalien.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addNewBook(Book newBook) {

        bookRepository.save(newBook);

    }

    public void DeleteById(Long bookId) {

        bookRepository.deleteById(bookId);

    }


    public Book findById(Long bookId) {

        return bookRepository.findById(bookId).get();

    }

    public void saveBook(Book book) {

        bookRepository.save(book);

    }

    public List<Book> shoeAllBooks() {

        return bookRepository.findAll();

    }

}
