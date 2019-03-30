package pl.coderslab.spring01hibernate.entity;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


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

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private String description;

    private Integer pages;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    public Book() {
    }

    public Book(String title, Author author, Publisher publisher) {
        this.title = title;
        this.authors.add(author);
        this.publisher = publisher;
    }

    public Book(String title, Author author) {
        this.title = title;
        this.authors.add(author);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                //", authors=" + authors +
                ", rating=" + rating +
                ", publisher=" + publisher +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                '}';
    }
}
