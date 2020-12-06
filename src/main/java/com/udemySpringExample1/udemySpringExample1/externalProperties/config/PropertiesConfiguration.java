package com.udemySpringExample1.udemySpringExample1.externalProperties.config;

import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeDataLoader;
import com.udemySpringExample1.udemySpringExample1.externalProperties.DataLoader.FakeJmsLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
/*
*
@PropertySources(
        @PropertySource("classpath:abc.properties"),
        @PropertySource("classpath:xyz.properties")
)
*/
public class PropertiesConfiguration {
    @Value("${mysql.username}")
    String user;

    @Value("${mysql.password}")
    String password;

    @Value("${mysql.url}")
    String url;

    @Value("${guru.jms.username}")
    String jmsUser;

    @Value("${guru.jms.password}")
    String jmsPassword;

    @Value("${guru.jms.url}")
    String jmsUrl;

    @Bean
    FakeDataLoader getFakeDataLoader(Environment env) {
        FakeDataLoader fakeDataLoader = new FakeDataLoader();
        fakeDataLoader.setUserName(user);
        fakeDataLoader.setPassword(env.getProperty("PASSWORD"));
        fakeDataLoader.setUrl(url);
        return fakeDataLoader;
    }

    @Bean
    FakeJmsLoader getFakeJmsLoader() {
        FakeJmsLoader fakeJmsLoader = new FakeJmsLoader();
        fakeJmsLoader.setUsername(jmsUser);
        fakeJmsLoader.setPassword(jmsPassword);
        fakeJmsLoader.setUrl(jmsUrl);
        return fakeJmsLoader;
    }

    // As per spring 5 framework doc we don't need to define below bean any more.
    // If you are not using @PropertySource , then you use PropertySourcesPlaceholderConfig like this
    /*@Bean
    public static PropertySourcesPlaceholderConfigurer getProperty(){
        //environment.getProperty("");
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
