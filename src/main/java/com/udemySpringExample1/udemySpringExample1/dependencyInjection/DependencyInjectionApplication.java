package com.udemySpringExample1.udemySpringExample1.dependencyInjection;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.ConstructorInjectorController;
import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.ProfilesController;
import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.PropertyInjectorController;
import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.SetterInjectorController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

        ProfilesController profileController = (ProfilesController) context.getBean("profilesController");
        log.info("-----Active Profile Bean-----");
        log.info(profileController.showGreeting());

        ConstructorInjectorController constructorInjectorController = (ConstructorInjectorController) context.getBean("constructorInjectorController");
        log.info("-----Constructor Bean-----");
        log.info(constructorInjectorController.showGreeting());

        PropertyInjectorController propertyInjectorController = (PropertyInjectorController) context.getBean("propertyInjectorController");
        log.info("-----Property Bean-----");
        log.info(propertyInjectorController.showGreeting());

        SetterInjectorController setterInjectorController = (SetterInjectorController) context.getBean("setterInjectorController");
        log.info("----Setter Bean-----");
        log.info(setterInjectorController.showGreeting());
    }

}
