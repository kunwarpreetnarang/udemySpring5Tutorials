package com.udemySpringExample1.udemySpringExample1.recipieApp.Repository;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import org.springframework.data.repository.CrudRepository;

public interface RecipieRepository extends CrudRepository<Recipies, Long> {
}
