package com.udemySpringExample1.udemySpringExample1.recipieApp.Repository;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Categories, Long> {
}
