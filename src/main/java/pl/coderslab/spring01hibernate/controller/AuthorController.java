package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.AuthorDao;
import pl.coderslab.spring01hibernate.entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;

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


    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Author author) {
        authorDao.update(author);
        return "redirect:list";
    }

}
