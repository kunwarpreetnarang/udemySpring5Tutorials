package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.IngredientsDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Ingredients;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientDoConverter implements Converter<IngredientsDO, Ingredients> {

    private final UnitOfMeasureDoConverter unitOfMeasureDoConverter;

    public IngredientDoConverter(UnitOfMeasureDoConverter unitOfMeasureDoConverter) {
        this.unitOfMeasureDoConverter = unitOfMeasureDoConverter;
    }

    @Nullable
    @Override
    public Ingredients convert(IngredientsDO ingredientsDO) {
        if(ingredientsDO == null)
            return null;
        final Ingredients ingredients= new Ingredients();
        ingredients.setAmount(ingredientsDO.getAmount());
        ingredients.setId(ingredientsDO.getId());
        ingredients.setDescription(ingredientsDO.getDescription());
        ingredients.setUnitOfMeasure(unitOfMeasureDoConverter.convert(ingredientsDO.getUnitOfMeasureDO()));
        return ingredients;
    }
}
