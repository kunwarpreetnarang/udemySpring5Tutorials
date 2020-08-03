package com.udemySpringExample1.udemySpringExample1.externalProperties;

import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeDataLoader;
import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeJmsLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExternalPropertiesApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ExternalPropertiesApplication.class, args);

        FakeDataLoader fakeDataLoader = context.getBean(FakeDataLoader.class);

        System.out.println("------- MySQL information loading -------------");
        System.out.println("UserName: " + fakeDataLoader.getUserName());
        System.out.println("Password: " + fakeDataLoader.getPassword());
        System.out.println("URL: " + fakeDataLoader.getUrl());

        System.out.println("------- JMS information loading -------------");
        FakeJmsLoader fakeJmsLoader = context.getBean(FakeJmsLoader.class);
        System.out.println("UserName: " + fakeJmsLoader.getUsername());
        System.out.println("Password: " + fakeJmsLoader.getPassword());
        System.out.println("URL: " + fakeJmsLoader.getUrl());

    }

}
