package com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Primary
@Service("languageProfile")
public class EnglishProfileServiceImpl implements GreetingService{
    @Override
    public String getGreetings() {
        return "English service is activated";
    }
}
