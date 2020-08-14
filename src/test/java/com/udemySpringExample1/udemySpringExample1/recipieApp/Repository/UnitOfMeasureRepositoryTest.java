package com.udemySpringExample1.udemySpringExample1.recipieApp.Repository;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
// Add this annotation to test Jpa data
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUom() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("teaspoon");

        assertEquals("teaspoon", unitOfMeasure.get().getUom());
    }

    // The second test will run fast as spring context is loaded.
    @Test
    public void findByUomTable() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("tablespoon");

        assertEquals("tablespoon", unitOfMeasure.get().getUom());
    }
}