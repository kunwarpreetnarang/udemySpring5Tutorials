package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ProfilesController {

    private  final GreetingService greetingService;

    public ProfilesController(@Qualifier("languageProfile") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String showGreeting(){
        return("Constructor Injected: " + greetingService.getGreetings());
    }
}
