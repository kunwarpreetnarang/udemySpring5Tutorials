package com.udemySpringExample1.udemySpringExample1.udemystudent.Controller;

import com.udemySpringExample1.udemySpringExample1.udemystudent.Repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class TeacherController {
    private  final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping("/teacher-list")
    public String getTeachers(Model model){
        log.info("fetching teachers list");
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teachers/teachers-list";
    }
}
