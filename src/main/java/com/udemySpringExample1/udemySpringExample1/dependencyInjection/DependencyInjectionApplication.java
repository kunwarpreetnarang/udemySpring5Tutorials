package com.udemySpringExample1.udemySpringExample1.dependencyInjection;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.ConstructorInjectorController;
import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.PropertyInjectorController;
import com.udemySpringExample1.udemySpringExample1.dependencyInjection.Controllers.SetterInjectorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

        ConstructorInjectorController constructorInjectorController = (ConstructorInjectorController) context.getBean("constructorInjectorController");
        System.out.println("-----Constructor Bean-----");
        System.out.println(constructorInjectorController.showGreeting());

        PropertyInjectorController propertyInjectorController = (PropertyInjectorController) context.getBean("propertyInjectorController");
        System.out.println("-----Property Bean-----");
        System.out.println(propertyInjectorController.showGreeting());

        SetterInjectorController setterInjectorController = (SetterInjectorController) context.getBean("setterInjectorController");
        System.out.println("----Setter Bean-----");
        System.out.println(setterInjectorController.showGreeting());
    }

}
