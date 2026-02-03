package am.itspace.libraryspring.service.impl;

import am.itspace.libraryspring.model.Book;
import am.itspace.libraryspring.repository.BookRepository;
import am.itspace.libraryspring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(Integer categoryId, String keyword) {
        bookRepository.searchBooks(categoryId, keyword);
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }
}
