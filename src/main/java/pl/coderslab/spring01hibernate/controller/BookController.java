package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping(value="/books",produces = "text/plain;charset=UTF-8")
public class BookController {


    private PublisherDao publisherDao;
    private BookDao bookDao;
    private AuthorDao authorDao;

    @Autowired
    public BookController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }




    @ModelAttribute("publishers")
    private List<Publisher> getPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    private List<Author> getAuthors() {
        return authorDao.findAll();
    }

    @ModelAttribute("books")
    private List<Book> getBooks() {
        return bookDao.findAll();
    }

}
