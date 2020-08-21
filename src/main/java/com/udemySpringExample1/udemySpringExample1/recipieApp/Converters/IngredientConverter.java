package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.IngredientsDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Ingredients;
import jdk.internal.jline.internal.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientConverter implements Converter<Ingredients, IngredientsDO> {

    private final UnitOfMeasureConverter unitOfMeasureConverter;

    public IngredientConverter(UnitOfMeasureConverter unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Nullable
    @Override
    public IngredientsDO convert(Ingredients ingredients) {
        if(ingredients == null)
            return null;
        final IngredientsDO ingredientsDO = new IngredientsDO();
        ingredientsDO.setAmount(ingredients.getAmount());
        ingredientsDO.setId(ingredients.getId());
        ingredientsDO.setAmount(ingredients.getAmount());
        ingredientsDO.setUnitOfMeasureDO(unitOfMeasureConverter.convert(ingredients.getUnitOfMeasure()));
        return ingredientsDO;
    }
}
