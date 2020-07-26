package com.udemySpringExample1.udemySpringExample1.jokesApp.Controllers;

import com.udemySpringExample1.udemySpringExample1.jokesApp.Services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final JokesService jokesService;

    @Autowired
    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"/",""})
    public String getJokes(Model model){
        String joke = jokesService.getJokes();
        model.addAttribute("joke",joke);
        return ("jokes/chuck-norris");
    }
}
