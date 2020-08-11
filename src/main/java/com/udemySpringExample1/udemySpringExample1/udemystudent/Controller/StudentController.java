package com.udemySpringExample1.udemySpringExample1.udemystudent.Controller;

import com.udemySpringExample1.udemySpringExample1.udemystudent.Repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/student-list")
    public String getStudentList(Model model){
        log.debug("Fetching student List:");
        model.addAttribute("students",studentRepository.findAll());
        return("students/students-list");
    }
}
