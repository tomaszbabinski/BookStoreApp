package pl.coderslab.spring01hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.spring01hibernate.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    @Query("SELECT a FROM Author a WHERE a.email LIKE :beginning%")
    List<Author> findByEmailBeginningWithQuery(@Param("beginning")String beginning);

    @Query("SELECT a FROM Author a WHERE a.pesel LIKE :beginning%")
    List<Author> findByPeselBeginningWithQuery(@Param("beginning")String beginning);

}
