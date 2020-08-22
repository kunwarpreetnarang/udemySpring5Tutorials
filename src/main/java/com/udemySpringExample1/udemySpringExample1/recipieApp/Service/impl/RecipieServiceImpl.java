package com.udemySpringExample1.udemySpringExample1.recipieApp.Service.impl;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Converters.RecipiesConverter;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Converters.RecipiesDoConverter;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipieServiceImpl implements RecipieService {

    private final RecipieRepository recipieRepository;
    private final RecipiesConverter recipiesConverter;
    private final RecipiesDoConverter recipiesDoConverter;

    public RecipieServiceImpl(RecipieRepository recipieRepository, RecipiesConverter recipiesConverter, RecipiesDoConverter recipiesDoConverter) {
        this.recipieRepository = recipieRepository;
        this.recipiesConverter = recipiesConverter;
        this.recipiesDoConverter = recipiesDoConverter;
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

    @Override
    @Transactional
    public RecipiesDO saveRecipie(RecipiesDO recipiesDO) {
        Recipies recipies = new Recipies();
        recipies = recipiesDoConverter.convert(recipiesDO);
        Recipies savedRecipie = recipieRepository.save(recipies);
        return recipiesConverter.convert(savedRecipie);
    }

    @Transactional
    @Override
    public RecipiesDO findRecipieDoById(Long id) {
        return recipiesConverter.convert(getRecipieById(id));
    }
}
