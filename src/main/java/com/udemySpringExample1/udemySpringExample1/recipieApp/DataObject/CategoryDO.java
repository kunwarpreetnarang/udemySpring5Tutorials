package com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CategoryDO {
    Long categoryId;
    String categoryDescription;
}
