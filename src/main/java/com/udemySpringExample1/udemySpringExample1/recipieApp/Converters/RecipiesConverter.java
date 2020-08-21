package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipiesConverter implements Converter<Recipies, RecipiesDO> {

    private final IngredientConverter ingredientConverter;
    private final CategoryConverter categoryConverter;
    private final NotesConverter notesConverter;

    public RecipiesConverter(IngredientConverter ingredientConverter, CategoryConverter categoryConverter, NotesConverter notesConverter) {
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
        this.notesConverter = notesConverter;
    }

    @Nullable
    @Override
    public RecipiesDO convert(Recipies recipies) {
        if(recipies == null)
           return null;
        final RecipiesDO recipiesDO = new RecipiesDO();
        recipiesDO.setDescription(recipies.getDescription());
        recipiesDO.setRecipieId(recipies.getId());
        recipiesDO.setDifficulty(recipies.getDifficulty());
        recipiesDO.setPreparationTime(recipies.getPrepTime());
        recipiesDO.setSource(recipies.getSource());
        recipiesDO.setUrl(recipies.getUrl());
        recipiesDO.setNotesDO(notesConverter.convert(recipies.getNotes()));

        if (recipies.getCategories() != null && recipies.getCategories().size() > 0){
            recipies.getCategories()
                    .forEach( category -> recipiesDO.getCategoryDO().add(categoryConverter.convert(category)));
        }

        if (recipies.getIngredients() != null && recipies.getIngredients().size() > 0){
            recipies.getIngredients()
                    .forEach(ingredient -> recipiesDO.getIngredientsDO().add(ingredientConverter.convert(ingredient)));
        }
        return recipiesDO;
    }
}
