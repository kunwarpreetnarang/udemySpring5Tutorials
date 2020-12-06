package com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject;

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
    Long recipieId;
}
