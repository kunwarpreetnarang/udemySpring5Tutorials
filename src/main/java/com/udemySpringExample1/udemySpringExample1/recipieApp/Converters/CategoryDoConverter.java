package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.CategoryDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryDoConverter implements Converter<CategoryDO, Categories> {

    @Nullable
    @Override
    public Categories convert(CategoryDO categoryDO) {
        if(categoryDO == null)
            return null;
        final Categories categories = new Categories();
        categories.setCategoryName(categoryDO.getCategoryDescription());
        categories.setId(categoryDO.getCategoryId());
        return categories;
    }
}
