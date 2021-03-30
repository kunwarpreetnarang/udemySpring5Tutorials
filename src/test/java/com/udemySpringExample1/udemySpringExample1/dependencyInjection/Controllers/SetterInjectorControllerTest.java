package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.ConstructorGreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetterInjectorControllerTest {

    SetterInjectorController setterInjectorController;
    @Before
    public void setUp() throws Exception {
        setterInjectorController = new SetterInjectorController();
        setterInjectorController.setGreetingService(new ConstructorGreetingServiceImpl());
    }

    @Test
    public void showGreeting() {
        String res = "Setter Injected: Dependency Injection implementation without spring context!";
        System.out.println(setterInjectorController.showGreeting());
        assertEquals(setterInjectorController.showGreeting(), res);
    }
}