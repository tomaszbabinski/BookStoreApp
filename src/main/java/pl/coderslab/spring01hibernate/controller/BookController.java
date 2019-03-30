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
import pl.coderslab.spring01hibernate.entity.Category;
import pl.coderslab.spring01hibernate.entity.Publisher;
import pl.coderslab.spring01hibernate.repository.BookRepository;
import pl.coderslab.spring01hibernate.repository.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping(value="/books")
public class BookController {

    private CategoryRepository categoryRepository;
    private BookRepository bookRepository;
    private PublisherDao publisherDao;
    private BookDao bookDao;
    private AuthorDao authorDao;

    @Autowired
    public BookController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao,BookRepository bookRepository,
    CategoryRepository categoryRepository) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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

    @GetMapping("/getBook/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookDao.findById(id));

        return "/book/bookForms";
    }

    @PostMapping("/getBook/**")
    public String editBook(@ModelAttribute Book book) {

        bookDao.update(book);

        return "redirect:/books/presentBookForm";
    }

    @GetMapping("/confirmDeletingBook/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        model.addAttribute("book", bookDao.findById(id));
        return "/book/deleteConfirmation";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id){
        bookDao.delete(bookDao.findById(id));
        return "/book/allBooks";
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


    //Test repository day 4 exercises
    @GetMapping(value = "/testRepository",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testRepository(){

        final long count = bookRepository.count();
        final List<Book> books = bookRepository.findAll();
        String html = "<div>Liczba książek w bazie: " + count + "</div>";

        for(Book b: books) {

            html+="<div>"+b.toString()+"</div>";
        }

        html+="<div>By Title</div>";
        final List<Book> booksByTitle = bookRepository.findAllByTitle("Ogniem i mieczem");
        for(Book b: booksByTitle) {

            html+="<div>"+b.toString()+"</div>";
        }

        html+="<div>By Category</div>";

        final Category category = categoryRepository.findOne(1L);
        final List<Book> booksByCategory = bookRepository.findAllByCategory(category);
        for(Book b: booksByCategory) {

            html+="<div>"+b.toString()+"</div>";
        }

        return html;

    }

}
