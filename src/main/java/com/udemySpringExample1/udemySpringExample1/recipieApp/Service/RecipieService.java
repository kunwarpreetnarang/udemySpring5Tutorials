package com.udemySpringExample1.udemySpringExample1.recipieApp.Service;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;

import java.util.List;

public interface RecipieService {
    public List<Recipies> getRecipies();

    public Recipies getRecipieById(Long recipeieId);
}
