package com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientsDO {
    Long id;
    String description;
    Long amount;
    UnitOfMeasureDO unitOfMeasureDO;
}
