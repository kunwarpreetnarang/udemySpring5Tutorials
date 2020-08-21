package com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDO {
    Long categoryId;
    String categoryDescription;
}
