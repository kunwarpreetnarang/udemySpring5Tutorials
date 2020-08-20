package com.udemySpringExample1.udemySpringExample1.recipieApp.Service.impl;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipieServiceImpl implements RecipieService {

    private final RecipieRepository recipieRepository;

    public RecipieServiceImpl(RecipieRepository recipieRepository) {
        this.recipieRepository = recipieRepository;
    }

    @Override
    public List<Recipies> getRecipies() {
        List<Recipies> recipieSet = new ArrayList<>();
        recipieRepository.findAll().iterator().forEachRemaining(recipieSet::add);
        return recipieSet;
    }

    @Override
    public Recipies getRecipieById(Long recipeieId) {
        Recipies recipie = recipieRepository.findById(recipeieId).orElse(null);
        return recipie;
    }
}
