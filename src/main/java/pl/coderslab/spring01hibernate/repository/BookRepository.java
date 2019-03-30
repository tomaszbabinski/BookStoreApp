package pl.coderslab.spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long categoryId);
}
