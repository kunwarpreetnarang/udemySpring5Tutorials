package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class ConstructorInjectorControllerTest {

    ConstructorInjectorController constructorInjectorController;
    @Before
    public void setUp() throws Exception {
        constructorInjectorController = new ConstructorInjectorController( new GreetingServiceImpl());
    }

    @Test
    public void showGreeting() {
        System.out.println(constructorInjectorController.showGreeting());
    }
}