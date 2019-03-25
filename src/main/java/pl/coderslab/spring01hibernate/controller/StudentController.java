package pl.coderslab.spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.simple.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {


    @GetMapping("/add")
    public String addStudent(Model model){

        model.addAttribute("student",new Student());

        return "studentForm";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addStudentProcess(@ModelAttribute Student student){

        return student.toString();
    }


    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Italy", "Belgium");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("Snowboarding", "Guitar playing", "Book reading", "Listing to Jazz Music", "Dreaming");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Python", "C#", "C++", "Ruby");
    }
}
