package com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Constants.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipiesDO {

    Long recipieId;

    @Min(1)
    @Max(1000)
    int preparationTime;

    @NotBlank
    String source;

    @URL
    String url;

    @NotBlank
    @Size(min = 10, max = 255)
    String description;

    NotesDO notesDO;
    Set<IngredientsDO> ingredientsDO = new HashSet<>();
    Set<CategoryDO> categoryDO = new HashSet<>();
    Difficulty difficulty;

    @NotBlank
    String directions;
    Byte[] images;
}
