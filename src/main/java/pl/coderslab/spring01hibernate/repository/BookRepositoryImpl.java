package pl.coderslab.spring01hibernate.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void resetRating(BigDecimal rating) {

        Query query = entityManager.createQuery("UPDATE Book b SET b.rating= :rating");
        query.setParameter("rating",rating).executeUpdate();

    }
}
