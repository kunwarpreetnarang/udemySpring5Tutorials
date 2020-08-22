package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipiesDoConverter implements Converter<RecipiesDO, Recipies> {

    private final IngredientDoConverter ingredientDoConverter;
    private final CategoryDoConverter categoryDoConverter;
    private final NotesDoConverter notesDoConverter;

    public RecipiesDoConverter(IngredientDoConverter ingredientDoConverter, CategoryDoConverter categoryDoConverter, NotesDoConverter notesDoConverter) {
        this.ingredientDoConverter = ingredientDoConverter;
        this.categoryDoConverter = categoryDoConverter;
        this.notesDoConverter = notesDoConverter;
    }

    @Nullable
    @Override
    public Recipies convert(RecipiesDO recipiesDO) {
        if(recipiesDO == null)
            return null;
        final Recipies recipies = new Recipies();
        recipies.setSource(recipiesDO.getSource());
        recipies.setDescription(recipiesDO.getDescription());
        recipies.setId(recipiesDO.getRecipieId());
        recipies.setUrl(recipiesDO.getUrl());
        recipies.setDifficulty(recipiesDO.getDifficulty());
        recipies.setPrepTime(recipiesDO.getPreparationTime());
        recipies.setNotes(notesDoConverter.convert(recipiesDO.getNotesDO()));
        recipies.setDirections(recipiesDO.getDirections());

        if (recipiesDO.getCategoryDO() != null && recipiesDO.getCategoryDO().size() > 0){
            recipiesDO.getCategoryDO()
                    .forEach( category -> recipies.getCategories().add(categoryDoConverter.convert(category)));
        }

        if (recipiesDO.getIngredientsDO() != null && recipiesDO.getIngredientsDO().size() > 0){
            recipiesDO.getIngredientsDO()
                    .forEach(ingredient -> recipies.getIngredients().add(ingredientDoConverter.convert(ingredient)));
        }
        return recipies;
    }
}
