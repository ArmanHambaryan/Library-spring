package am.itspace.libraryspring.service;

import am.itspace.libraryspring.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void deleteCategory(Integer id);

    Category save(Category category);
}
