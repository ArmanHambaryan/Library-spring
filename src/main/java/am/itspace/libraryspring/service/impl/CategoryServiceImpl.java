package am.itspace.libraryspring.service.impl;

import am.itspace.libraryspring.model.Category;
import am.itspace.libraryspring.repository.CategoryRepository;
import am.itspace.libraryspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
