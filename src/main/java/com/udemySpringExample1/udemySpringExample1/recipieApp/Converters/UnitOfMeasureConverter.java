package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.UnitOfMeasureDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureConverter implements Converter<UnitOfMeasure, UnitOfMeasureDO> {

    @Nullable
    @Override
    public UnitOfMeasureDO convert(UnitOfMeasure source) {
        if(source == null){
            return null;
        }
        final UnitOfMeasureDO unitOfMeasureDO = new UnitOfMeasureDO();
        unitOfMeasureDO.setUomId(source.getId());
        unitOfMeasureDO.setUom(source.getUom());
        return unitOfMeasureDO;
    }
}
