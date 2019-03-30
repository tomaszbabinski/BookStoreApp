package pl.coderslab.spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Category;
import pl.coderslab.spring01hibernate.entity.Publisher;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long categoryId);
    List<Book> findAllByAuthorsId(Long authorId);
    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByRating(BigDecimal rating);
    Book findFirstBookByCategoryOrderByTitleAsc(Category category);
}
