package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.dao.BookDao;
import pl.coderslab.spring01hibernate.dao.PublisherDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.entity.Book;
import pl.coderslab.spring01hibernate.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping(value="/books")
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


    @GetMapping("/addBook")
    public String addBook(Model model){
        model.addAttribute("book",new Book());
        return "/book/addBook";
    }

    @PostMapping("/addBook")
    @ResponseBody
    public String addBookProcess(@ModelAttribute Book book){
        bookDao.saveBook(book);
        return "zapisano";
    }

    @GetMapping("/showAllBooks")
    public String showAllBooks(Model model){
        model.addAttribute("books",getBooks());
        return "/book/allBooks";
    }

    /*Form Entities Exercises*/

    @GetMapping("/presentBookForm")
    public String bookForm(Model model){
        model.addAttribute("book", new Book());
        return "/book/bookForms";
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
