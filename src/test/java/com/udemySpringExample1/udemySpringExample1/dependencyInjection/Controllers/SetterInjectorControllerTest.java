package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.ConstructorGreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class SetterInjectorControllerTest {

    SetterInjectorController setterInjectorController;
    @Before
    public void setUp() throws Exception {
        setterInjectorController = new SetterInjectorController();
        setterInjectorController.setGreetingService(new ConstructorGreetingServiceImpl());
    }

    @Test
    public void showGreeting() {
        System.out.println(setterInjectorController.showGreeting());
    }
}