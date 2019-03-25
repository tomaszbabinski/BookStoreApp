package pl.coderslab.spring01hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "authors")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    //@JsonIgnore
    private Set<Book> books = new HashSet<>();


    private String email;

    private String pesel;

    private Integer yearOfBirth;

    public Author() {
    }


}