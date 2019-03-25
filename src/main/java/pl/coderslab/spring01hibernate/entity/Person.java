package pl.coderslab.spring01hibernate.entity;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private PersonDetail personDetail;

    public Person() {
    }


    public Person(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
