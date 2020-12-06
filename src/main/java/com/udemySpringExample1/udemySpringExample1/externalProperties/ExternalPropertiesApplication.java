package com.udemySpringExample1.udemySpringExample1.externalProperties;

import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeDataLoader;
import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeJmsLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class ExternalPropertiesApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ExternalPropertiesApplication.class, args);

        FakeDataLoader fakeDataLoader = context.getBean(FakeDataLoader.class);

        log.info("------- MySQL information loading -------------");
        log.info("UserName: " + fakeDataLoader.getUserName());
        log.info("Password: " + fakeDataLoader.getPassword());
        log.info("URL: " + fakeDataLoader.getUrl());

        FakeJmsLoader fakeJmsLoader = context.getBean(FakeJmsLoader.class);
        log.info("------- JMS information loading -------------");
        log.info("UserName: " + fakeJmsLoader.getUsername());
        log.info("Password: " + fakeJmsLoader.getPassword());
        log.info("URL: " + fakeJmsLoader.getUrl());

    }

}
