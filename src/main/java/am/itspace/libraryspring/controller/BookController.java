package am.itspace.libraryspring.controller;

import am.itspace.libraryspring.model.Book;
import am.itspace.libraryspring.model.Category;
import am.itspace.libraryspring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import am.itspace.libraryspring.repository.BookRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/book")
    public String BookPage(ModelMap modelMap, @RequestParam(value = "categoryId", defaultValue = "0") int categoryId,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        List<Book> books = bookRepository.searchBooks(categoryId, keyword);
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "book";
    }

    @GetMapping("/books/add")
    public String addBookPage(ModelMap modelMap) {
        List<Book> books = bookRepository.findAll();
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("categories", categoryRepository.findAll());
        return "addBook";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book, @RequestParam("category") Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        book.setCategory(category);
        bookRepository.save(book);
        return "redirect:/book";
    }

    @GetMapping("/books/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/book";
    }


}
