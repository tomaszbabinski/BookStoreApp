package pl.coderslab.spring01hibernate.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="personDetails")
public class PersonDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String street;
    private String city;

    public PersonDetail() {
    }
}
