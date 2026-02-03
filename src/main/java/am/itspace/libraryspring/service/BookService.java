package am.itspace.libraryspring.service;

import am.itspace.libraryspring.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    List<Book> searchBooks(Integer categoryId, String keyword);

    Book save(Book book);

    void deleteById(Integer id);

    Book findById(Integer id);

}
