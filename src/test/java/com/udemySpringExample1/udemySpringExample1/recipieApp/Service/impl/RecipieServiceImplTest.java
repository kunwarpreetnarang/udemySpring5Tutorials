package com.udemySpringExample1.udemySpringExample1.recipieApp.Service.impl;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Converters.*;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.IngredientRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class RecipieServiceImplTest {
    RecipieServiceImpl recipieService;

    @Mock
    RecipieRepository recipieRepository;

    @Mock
    RecipiesDoConverter recipiesDoConverter;

    @Mock
    RecipiesConverter recipiesConverter;

    @Mock
    IngredientConverter ingredientConverter;

    @Mock
    IngredientDoConverter ingredientDoConverter;

    @Mock
    IngredientRepository ingredientRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Mock
    UnitOfMeasureConverter unitOfMeasureConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipieService = new RecipieServiceImpl(recipieRepository, recipiesConverter, recipiesDoConverter, ingredientConverter, ingredientDoConverter, ingredientRepository, unitOfMeasureRepository, unitOfMeasureConverter
        );
    }

    @Test
    public void getRecipies() {
        Recipies recipies = new Recipies();
        Recipies recipies1 = new Recipies();
        HashSet recipeList = new HashSet();
        recipeList.add(recipies);
        recipeList.add(recipies1);
        when(recipieRepository.findAll()).thenReturn(recipeList);

        List<Recipies> recipiesSet = recipieService.getRecipies();

        assertEquals(2, recipiesSet.size());
        verify(recipieRepository, times(1)).findAll();
    }

}