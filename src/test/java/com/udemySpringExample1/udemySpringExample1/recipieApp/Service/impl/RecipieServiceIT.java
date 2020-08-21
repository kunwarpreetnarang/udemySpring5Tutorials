package com.udemySpringExample1.udemySpringExample1.recipieApp.Service.impl;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Converters.RecipiesConverter;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Converters.RecipiesDoConverter;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.UnitOfMeasure;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.UnitOfMeasureRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipieServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipieService recipeService;

    @Autowired
    RecipieRepository recipeRepository;

    @Autowired
    RecipiesDoConverter recipeCommandToRecipe;

    @Autowired
    RecipiesConverter recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() throws Exception {
        //given
        Iterable<Recipies> recipes = recipeRepository.findAll();
        Recipies testRecipe = recipes.iterator().next();
        RecipiesDO testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipiesDO savedRecipeCommand = recipeService.saveRecipie(testRecipeCommand);

        //then
        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeCommand.getRecipieId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategoryDO().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredientsDO().size());
    }
}