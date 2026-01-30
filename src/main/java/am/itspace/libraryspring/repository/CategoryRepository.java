package am.itspace.libraryspring.repository;

import am.itspace.libraryspring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
