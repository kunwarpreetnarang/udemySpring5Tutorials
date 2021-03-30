package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.ConstructorGreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstructorInjectorControllerTest {

    ConstructorInjectorController constructorInjectorController;
    @Before
    public void setUp() throws Exception {
        constructorInjectorController = new ConstructorInjectorController( new ConstructorGreetingServiceImpl());
    }

    @Test
    public void showGreeting() {
        System.out.println(constructorInjectorController.showGreeting());
        String res = "Constructor Injected: Dependency Injection implementation without spring context!";
        assertEquals(constructorInjectorController.showGreeting(), res);
    }
}