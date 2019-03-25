package pl.coderslab.spring01hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);

    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public List<Book> findAll() {
        final Query q = this.entityManager.createQuery("SELECT e FROM Book e");
        return q.getResultList();
    }

    public List<Book> findByRating(BigDecimal rating) {
        final Query q = this.entityManager.createQuery("SELECT e FROM Book e where rating =:rating");
        q.setParameter("rating",rating);
        return q.getResultList();
    }


}
