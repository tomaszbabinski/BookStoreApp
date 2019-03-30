package pl.coderslab.spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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





    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book>returnBooksByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book>returnBooksbyCategory(@Param("category") Category category);

    @Query("SELECT b FROM Book b WHERE b.rating >= ?1 AND b.rating <= ?2")
    List<Book>returnBooksfromRatingRange(BigDecimal min, BigDecimal max);

    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher")
    List<Book>returnBooksByPublisher(@Param("publisher") Publisher publisher);

    @Query(value = "Select * From books where category_id = ?1 order by title asc Limit 1", nativeQuery = true)
    Book findFirstBookByCategorySortedByTitleQuery(Long id);

}
