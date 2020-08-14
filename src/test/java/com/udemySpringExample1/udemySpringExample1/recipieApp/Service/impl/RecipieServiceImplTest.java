package com.udemySpringExample1.udemySpringExample1.recipieApp.Service.impl;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.RecipieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class RecipieServiceImplTest {
    RecipieServiceImpl recipieService;

    @Mock
    RecipieRepository recipieRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipieService = new RecipieServiceImpl(recipieRepository);
    }

    @Test
    public void getRecipies() {
        Recipies recipies = new Recipies();
        Recipies recipies1 = new Recipies();
        HashSet recipeList = new HashSet();
        recipeList.add(recipies);
        recipeList.add(recipies1);
        when(recipieRepository.findAll()).thenReturn(recipeList);

        List<Recipies> recipiesSet = recipieService.getRecipies();

        assertEquals(2, recipiesSet.size());
        verify(recipieRepository, times(1)).findAll();
    }
}