package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.entity.Author;
import pl.coderslab.spring01hibernate.repository.AuthorRepository;

@Controller
@RequestMapping("/author")
public class AuthorController {


    AuthorDao authorDao;
    AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/add")
    public String addAuthor(Model model){
        model.addAttribute("author",new Author());
        return "author/add";

    }

    @PostMapping("/add")
    @ResponseBody
    public String addAuthor(@ModelAttribute Author author){
        authorDao.saveAuthor(author);
        return "zapisano";

    }

    @GetMapping("/list")
    public String showAll(Model model){
        model.addAttribute("authors", authorDao.findAll());
        return "author/showAll";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("author",authorDao.findById(id));
        return "author/edit";
    }


    @PostMapping("/edit")
    public String edit(@ModelAttribute Author author) {
        authorDao.update(author);
        return "redirect:list";
    }

    @GetMapping("/confirmDeletingAuthor/{id}")
    public String remove(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "author/remove";
    }

    @PostMapping("/deleteAuthor")
    public String remove(@ModelAttribute Author author){
        //TODO
        return "redirect:list";
    }

    //Exercises day 4

    @GetMapping("/test/findByEmail/{param}")
    @ResponseBody
    public String findByEmailBeginningWith(@PathVariable String param){
        return authorRepository.findByEmailBeginningWithQuery(param).toString();
    }

}
