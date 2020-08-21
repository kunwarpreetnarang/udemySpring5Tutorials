package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.UnitOfMeasureDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureDoConverter implements Converter<UnitOfMeasureDO, UnitOfMeasure> {

    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureDO unitOfMeasureDO) {
        if(unitOfMeasureDO == null)
        return null;
        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUom(unitOfMeasureDO.getUom());
        unitOfMeasure.setId(unitOfMeasureDO.getUomId());
        return unitOfMeasure;
    }
}
