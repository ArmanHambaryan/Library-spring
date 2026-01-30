package am.itspace.libraryspring.repository;

import am.itspace.libraryspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("SELECT b FROM Book b WHERE (:categoryId = 0 OR b.category.id = :categoryId) " +
            "AND (LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    List<Book> searchBooks(@Param("categoryId") int categoryId, @Param("keyword") String keyword);

}
