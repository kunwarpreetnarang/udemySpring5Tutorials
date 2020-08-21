package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.CategoryDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<Categories, CategoryDO> {

    @Nullable
    @Override
    public CategoryDO convert(Categories categories) {
        if(categories == null)
            return null;
        final CategoryDO categoryDO = new CategoryDO();
        categoryDO.setCategoryDescription(categories.getCategoryName());
        categoryDO.setCategoryId(categories.getId());
        return categoryDO;
    }
}
