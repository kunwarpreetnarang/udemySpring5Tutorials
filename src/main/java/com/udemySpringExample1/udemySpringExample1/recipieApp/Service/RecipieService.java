package com.udemySpringExample1.udemySpringExample1.recipieApp.Service;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.CategoryDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.IngredientsDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.UnitOfMeasureDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface RecipieService {
    public List<Recipies> getRecipies();

    public Recipies getRecipieById(Long recipeieId);

    public RecipiesDO saveRecipie(RecipiesDO recipiesDO);

    public RecipiesDO findRecipieDoById(Long id);

    public RecipiesDO deleteRecipies(Long id);

    public IngredientsDO findIngredientById(Long recipieId, Long id);

    public void deleteIngredient(Long recipieId, Long id);

    public IngredientsDO saveIngredient(IngredientsDO ingredientsDO, Long recipieDO);

    public Set<UnitOfMeasureDO> listAllUOM();

    public RecipiesDO saveRecipeImage(MultipartFile multipartFile, long id);
}

