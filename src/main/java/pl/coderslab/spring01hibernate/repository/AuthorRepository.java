package pl.coderslab.spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernate.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {


}
