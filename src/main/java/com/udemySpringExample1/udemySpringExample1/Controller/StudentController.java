package com.udemySpringExample1.udemySpringExample1.Controller;

import com.udemySpringExample1.udemySpringExample1.Repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/student-list")
    public String getStudentList(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return("students/students-list");
    }
}
