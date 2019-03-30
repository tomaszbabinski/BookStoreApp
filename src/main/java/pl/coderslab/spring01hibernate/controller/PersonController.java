package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.PersonDao;
import pl.coderslab.spring01hibernate.dao.PersonDetailsDao;
import pl.coderslab.spring01hibernate.entity.Person;
import pl.coderslab.spring01hibernate.repository.PersonRepository;

import java.util.List;

@Controller
@RequestMapping(value="/persons")
public class PersonController {

    PersonDao personDao;
    PersonDetailsDao personDetailsDao;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping(path = "/personForm",method = RequestMethod.GET)
    public String personForm(Model model){

        model.addAttribute("personDetail",new Person());
        return "personForm";
    }

    @PostMapping(path = "/personFormToProcess")
    @ResponseBody
    public Person personFormToProcess(@ModelAttribute(name = "personDetail") Person person){

        this.personDao.savePerson(person);
        return person;
    }

    //Test repository
    @GetMapping(value = "/testRepository",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testRepository(){

        final long count = personRepository.count();
        final List<Person> persons = personRepository.findAll();
        String html = "<div>Liczba osób w bazie: " + count + "</div>";

        for(Person p: persons) {

            html+="<div>"+p.toString()+"</div>";
        }
        return html;

    }

}
