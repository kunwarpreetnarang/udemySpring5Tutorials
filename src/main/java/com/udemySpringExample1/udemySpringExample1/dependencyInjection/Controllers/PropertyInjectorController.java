package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectorController {
    @Autowired
    public GreetingService greetingService;

    public String showGreeting() {
        return ("Property Injected: " + greetingService.getGreetings());
    }
}

