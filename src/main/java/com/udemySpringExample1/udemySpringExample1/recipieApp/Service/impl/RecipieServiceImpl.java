package com.udemySpringExample1.udemySpringExample1.recipieApp.Service.impl;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Converters.*;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.CategoryDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.IngredientsDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.UnitOfMeasureDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Ingredients;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.IngredientRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.UnitOfMeasureRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipieServiceImpl implements RecipieService {

    private final RecipieRepository recipieRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private final RecipiesConverter recipiesConverter;
    private final RecipiesDoConverter recipiesDoConverter;
    private final IngredientConverter ingredientConverter;
    private final IngredientDoConverter ingredientDoConverter;
    private final UnitOfMeasureConverter unitOfMeasureConverter;
    private final CategoryConverter categoryConverter;

    public RecipieServiceImpl(RecipieRepository recipieRepository, RecipiesConverter recipiesConverter, RecipiesDoConverter recipiesDoConverter, IngredientConverter ingredientConverter, IngredientDoConverter ingredientDoConverter, IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureConverter unitOfMeasureConverter, CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.recipieRepository = recipieRepository;
        this.recipiesConverter = recipiesConverter;
        this.recipiesDoConverter = recipiesDoConverter;
        this.ingredientConverter = ingredientConverter;
        this.ingredientDoConverter = ingredientDoConverter;
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureConverter = unitOfMeasureConverter;
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
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

    @Transactional
    @Override
    public RecipiesDO deleteRecipies(Long id) {
        RecipiesDO recipiesDO = recipiesConverter.convert(getRecipieById(id));
        recipieRepository.deleteById(id);
        return recipiesDO;
    }

    @Override
    public IngredientsDO findIngredientById(Long recipieId, Long id) {
        Recipies recipies = getRecipieById(recipieId);
        Optional<IngredientsDO> ingredientsDO = recipies.getIngredients().stream()
                .filter(ingredients -> ingredients.getId().equals(id))
                .map(ingredients -> ingredientConverter.convert(ingredients)).findFirst();

        if (!ingredientsDO.isPresent()) {

        }
        return ingredientsDO.get();
    }

    @Transactional
    @Override
    public void deleteIngredient(Long recipieId, Long id) {
        Recipies recipies = getRecipieById(recipieId);
        Optional<Ingredients> ingredients = recipies.getIngredients().stream()
                .filter(ingredients1 -> ingredients1.getId().equals(id)).findFirst();

        if (ingredients.isPresent()) {
            Ingredients ingredients1 = ingredients.get();
            ingredients1.setRecipies(null);
            recipies.getIngredients().remove(ingredients.get());
            recipieRepository.save(recipies);
        } else {
            //todo handle exception
        }
    }

    @Override
    public IngredientsDO saveIngredient(IngredientsDO ingredientsDO, Long recipieId) {
        Ingredients ingredients = new Ingredients();
        ingredients = ingredientDoConverter.convert(ingredientsDO);
        Recipies recipies = new Recipies();
        recipies.setId(recipieId);
        ingredients.setRecipies(recipies);
        ingredients.setUnitOfMeasure(unitOfMeasureRepository
                .findById(ingredientsDO.getUnitOfMeasureDO().getUomId())
                .orElseThrow(() -> new RuntimeException("UOM NOT FOUND")));
        ingredientRepository.save(ingredients);
        return ingredientConverter.convert(ingredients);
    }

    @Override
    public Set<UnitOfMeasureDO> listAllUOM() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
                                                .map(unitOfMeasureConverter::convert)
                                                .collect(Collectors.toSet());
    }

}
