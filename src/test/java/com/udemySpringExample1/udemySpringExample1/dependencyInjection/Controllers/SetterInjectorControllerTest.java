package com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetterInjectorControllerTest {

    SetterInjectorController setterInjectorController;
    @Before
    public void setUp() throws Exception {
        setterInjectorController = new SetterInjectorController();
        setterInjectorController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void showGreeting() {
        System.out.println(setterInjectorController.showGreeting());
    }
}