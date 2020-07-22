package com.udemySpringExample1.udemySpringExample1.dependencyInjection.businessLogic;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// use default keyword in profile controller to make a default profile
@Profile({"PN" , "default"})
@Service("languageProfile")
public class PunjabiProfileServiceImpl implements GreetingService{
    @Override
    public String getGreetings() {
        return "punjabi language profile is activated";
    }
}
