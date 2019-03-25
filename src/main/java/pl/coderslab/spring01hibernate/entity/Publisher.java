package pl.coderslab.spring01hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String nip;

    private String regon;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private Set<Book>books = new HashSet<>();


    public Publisher() {
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", books=" + books +
                '}';
    }
}
