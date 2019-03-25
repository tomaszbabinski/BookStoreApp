package pl.coderslab.spring01hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {




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
