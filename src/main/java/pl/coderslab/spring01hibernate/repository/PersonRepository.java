package pl.coderslab.spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernate.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
