package com.udemySpringExample1.udemySpringExample1.recipieApp.Repository;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredients, Long> {
}
