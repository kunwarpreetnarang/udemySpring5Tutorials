package com.udemySpringExample1.udemySpringExample1.Controller;

import com.udemySpringExample1.udemySpringExample1.Model.Teacher;
import com.udemySpringExample1.udemySpringExample1.Repositories.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
    private  final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping("/teacher-list")
    public String getTeachers(Model model){
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teachers/teachers-list";
    }
}
