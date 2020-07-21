package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectorController {

    private  final  GreetingService greetingService;

    public ConstructorInjectorController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String showGreeting(){
        return("Constructor Injected: " + greetingService.getGreetings());
    }
}
