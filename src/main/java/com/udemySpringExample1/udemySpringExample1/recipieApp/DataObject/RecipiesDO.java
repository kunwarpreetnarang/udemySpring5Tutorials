package com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Constants.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipiesDO {

    Long recipieId;
    int preparationTime;
    String source;
    String url;
    String description;
    NotesDO notesDO;
    Set<IngredientsDO> ingredientsDO = new HashSet<>();
    Set<CategoryDO> categoryDO = new HashSet<>();
    Difficulty difficulty;
    String directions;
    Byte[] images;
}
