package com.udemySpringExample1.udemySpringExample1.recipieApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RecipieApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(RecipieApplication.class, args);

    }

}
