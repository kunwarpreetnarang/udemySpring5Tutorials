package com.udemySpringExample1.udemySpringExample1;

import com.udemySpringExample1.udemySpringExample1.dependencyInjection.DependencyInjectionApplication;
import com.udemySpringExample1.udemySpringExample1.jokesApp.JokesApplication;
import com.udemySpringExample1.udemySpringExample1.recipieApp.RecipieApplication;
import com.udemySpringExample1.udemySpringExample1.udemystudent.UdemySpringExample1Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UdemySpringExample1Application.class, DependencyInjectionApplication.class, JokesApplication.class, RecipieApplication.class})
class UdemySpringExample1ApplicationTests {

	@Test
	void contextLoads() {
	}

}
