package am.itspace.libraryspring.controller;

import am.itspace.libraryspring.model.Book;
import am.itspace.libraryspring.model.Category;
import am.itspace.libraryspring.service.BookService;
import am.itspace.libraryspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;

    @GetMapping("/book")
    public String BookPage(ModelMap modelMap, @RequestParam(value = "categoryId", defaultValue = "0") int categoryId,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        List<Book> books = bookService.searchBooks(categoryId, keyword);
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("categories", categoryService.findAll());
        return "book";
    }

    @GetMapping("/books/add")
    public String addBookPage(ModelMap modelMap) {
        List<Book> books = bookService.findAll();
        modelMap.addAttribute("books", books);
        modelMap.addAttribute("categories", categoryService.findAll());
        return "addBook";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book, @RequestParam("category") Integer categoryId) {
        Category category = categoryService.findById(categoryId).orElse(null);
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/books/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteById(id);
        return "redirect:/book";
    }


}
