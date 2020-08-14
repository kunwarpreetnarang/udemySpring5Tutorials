package com.udemySpringExample1.udemySpringExample1.recipieApp.Controller;

import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Categories;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Recipies;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Repository.CategoryRepository;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Service.RecipieService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    Model model;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    RecipieService recipieService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(categoryRepository, recipieService);
    }

    @Test
    public void getIndexPage() {
        Categories categories = new Categories();
        Optional<Categories> categories1 = null;
       // when(categoryRepository.findByCategoryName("Indian")).thenReturn(categories1);
        List<Recipies> recipies = new ArrayList<>();
        Recipies recipies1 = new Recipies();
        Recipies recipies2 = new Recipies();
        recipies2.setSource("aabbf");
        recipies.add(recipies1);
        recipies.add(recipies2);

        when(recipieService.getRecipies()).thenReturn(recipies);

        ArgumentCaptor<List<Recipies>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        String view = indexController.getIndexPage(model);

        assertEquals("recipie-app/index",view);
        verify(recipieService, times(1)).getRecipies();
        verify(model, times(1)).addAttribute(eq("recipies"), argumentCaptor.capture());

        List<Recipies> recipiesList = argumentCaptor.getValue();
        assertEquals(2, recipiesList.size());
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipie-app/index"));
    }
}