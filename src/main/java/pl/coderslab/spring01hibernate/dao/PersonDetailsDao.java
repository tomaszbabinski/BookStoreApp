package pl.coderslab.spring01hibernate.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.PersonDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePersonDetails(PersonDetail personDetail) {
        entityManager.persist(personDetail);
    }

    public PersonDetail findById(long id) {
        return entityManager.find(PersonDetail.class, id);

    }

    public void update(PersonDetail personDetail) {
        entityManager.merge(personDetail);
    }

    public void delete(PersonDetail personDetail) {
        entityManager.remove(entityManager.contains(personDetail) ?
                personDetail : entityManager.merge(personDetail));
    }

    public List<PersonDetail> findAll() {
        return entityManager.createQuery("SELECT pd FROM PersonDetail pd")
                .getResultList();
    }

    }
