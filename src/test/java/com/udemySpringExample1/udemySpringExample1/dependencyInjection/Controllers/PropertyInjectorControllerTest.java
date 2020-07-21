package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class PropertyInjectorControllerTest {
    private PropertyInjectorController propertyInjectorController;

    @Before
    public void setUp() throws Exception {
        propertyInjectorController = new PropertyInjectorController();
        propertyInjectorController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void showGreeting() {
        System.out.println(propertyInjectorController.showGreeting());
    }
}