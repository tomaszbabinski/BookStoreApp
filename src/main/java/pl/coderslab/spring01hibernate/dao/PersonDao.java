package pl.coderslab.spring01hibernate.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernate.entity.Person;
import pl.coderslab.spring01hibernate.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);

    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

    public List<Person> findAll() {
        final Query q = this.entityManager.createQuery("SELECT e FROM Person e");
        return q.getResultList();
    }
}
