package com.udemySpringExample1.udemySpringExample1.jokesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JokesApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JokesApplication.class, args);
        context.getApplicationName();
    }

}
