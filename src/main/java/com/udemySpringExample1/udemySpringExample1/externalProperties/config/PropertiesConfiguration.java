package com.udemySpringExample1.udemySpringExample1.externalProperties.config;

import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeDataLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertiesConfiguration {
    @Value("${mysql.username}")
    String user;

    @Value("${mysql.password}")
    String password;

    @Value("${mysql.url}")
    String url;

    @Bean
    FakeDataLoader getFakeDataLoader(){
        FakeDataLoader fakeDataLoader = new FakeDataLoader();
        fakeDataLoader.setUserName(user);
        fakeDataLoader.setPassword(password);
        fakeDataLoader.setUrl(url);
        return fakeDataLoader;
    }
    //static Environment environment;

    // As per spring 5 framework doc we don't need to define below bean any more.
    // If you are not using @PropertySource , then you use PropertySourcesPlaceholderConfig like this
    /*@Bean
    public static PropertySourcesPlaceholderConfigurer getProperty(){
        //environment.getProperty("");
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
