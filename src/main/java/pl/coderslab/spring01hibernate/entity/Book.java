package pl.coderslab.spring01hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book {

    //alt+shift
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    private BigDecimal rating;

    @ManyToOne()
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private String description;

    private Integer pages;

    public Book() {
    }

    public Book(String title, Author author, Publisher publisher) {
        this.title = title;
        this.authors.add(author);
        this.publisher = publisher;
    }


   }
