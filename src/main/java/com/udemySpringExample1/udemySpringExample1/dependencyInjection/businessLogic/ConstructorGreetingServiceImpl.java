package com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingServiceImpl implements GreetingService {
    @Override
    public String getGreetings() {
        return "Dependency Injection implementation without spring context!";
    }
}
