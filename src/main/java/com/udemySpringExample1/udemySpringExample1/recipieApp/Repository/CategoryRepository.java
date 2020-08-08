package com.udemySpringExample1.udemySpringExample1.recipieApp.Repository;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Categories, Long> {
    List<Categories> findByCategoryName(String categoryName);
}
