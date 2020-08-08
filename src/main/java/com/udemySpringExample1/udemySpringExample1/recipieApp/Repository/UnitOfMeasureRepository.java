package com.udemySpringExample1.udemySpringExample1.recipieApp.Repository;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByUom(String measure);
}
