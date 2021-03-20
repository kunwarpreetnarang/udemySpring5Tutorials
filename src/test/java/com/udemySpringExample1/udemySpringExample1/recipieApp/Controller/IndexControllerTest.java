package com.udemySpringExample1.udemySpringExample1.recipieApp.Controller;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.IngredientsDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.RecipiesDO;
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

        assertEquals("recipie-app/index", view);
        verify(recipieService, times(1)).getRecipies();
        verify(model, times(1)).addAttribute(eq("recipies"), argumentCaptor.capture());

        List<Recipies> recipiesList = argumentCaptor.getValue();
        assertEquals(2, recipiesList.size());
    }

    @Test
    public void getRecipeForm() {
        ArgumentCaptor<RecipiesDO> argumentCaptor = ArgumentCaptor.forClass(RecipiesDO.class);
        String view = indexController.getRecipeForm(model);
        assertEquals("recipie-app/save-recipe", view);
        verify(model, times(1)).addAttribute(eq("recipeForm"), argumentCaptor.capture());
    }

    @Test
    public void getRecipeById() {
        String id = "1";
        Long recipeId = Long.valueOf(id);
        Recipies recipies = new Recipies();
        when(recipieService.getRecipieById(recipeId)).thenReturn(recipies);

        ArgumentCaptor<Recipies> argumentCaptor = ArgumentCaptor.forClass(Recipies.class);
        String view = indexController.getRecipieById(model, id);
        assertEquals("recipie-app/show-recipe", view);
        verify(recipieService, times(1)).getRecipieById(recipeId);

        verify(model, times(1)).addAttribute(eq("recipie"), argumentCaptor.capture());
    }

    @Test
    public void getIngredient() {
        String id = "1";
        Long recipeId = Long.valueOf(id);

        RecipiesDO recipies = new RecipiesDO();
        when(recipieService.findRecipieDoById(recipeId)).thenReturn(recipies);

        ArgumentCaptor<RecipiesDO> argumentCaptor = ArgumentCaptor.forClass(RecipiesDO.class);
        String view = indexController.getIngredient(id, model);
        assertEquals("recipie-app/list-ingredient", view);
        verify(recipieService, times(1)).findRecipieDoById(recipeId);

        verify(model, times(1)).addAttribute(eq("recipie"), argumentCaptor.capture());
    }

    @Test
    public void viewIngredient() {
        String recId = "1";
        Long recipeId = Long.valueOf(recId);
        String ingId = "2";
        Long ingredientId = Long.valueOf(ingId);
        IngredientsDO ingredientsDO = new IngredientsDO();
        when(recipieService.findIngredientById(recipeId, ingredientId)).thenReturn(ingredientsDO);

        ArgumentCaptor<IngredientsDO> argumentCaptor = ArgumentCaptor.forClass(IngredientsDO.class);
        String view = indexController.viewIngredient(recId, model, ingId);
        assertEquals("recipie-app/show-ingredient", view);
        verify(recipieService, times(1)).findIngredientById(recipeId, ingredientId);

        verify(model, times(1)).addAttribute(eq("ingredient"), argumentCaptor.capture());
    }

    @Test
    public void deleteRecipe() {
        String id = "1";
        Long recipeId = Long.valueOf(id);

        RecipiesDO recipies = new RecipiesDO();
        when(recipieService.deleteRecipies(recipeId)).thenReturn(recipies);

        ArgumentCaptor<RecipiesDO> argumentCaptor = ArgumentCaptor.forClass(RecipiesDO.class);
        String view = indexController.deleteRecipie(id, model);
        assertEquals("redirect:/index", view);
        verify(recipieService, times(1)).deleteRecipies(recipeId);

        verify(model, times(1)).addAttribute(eq("recipies"), argumentCaptor.capture());
    }

    @Test
    public void deleteIngredient() {
        String recId = "1";
        Long recipeId = Long.valueOf(recId);
        String ingId = "2";
        Long ingredientId = Long.valueOf(ingId);
        IngredientsDO ingredientsDO = new IngredientsDO();
        String view = indexController.deleteIngredient(recId, ingId);
        assertEquals("redirect:/recipie/show/" + recipeId, view);
        verify(recipieService, times(1)).deleteIngredient(recipeId, ingredientId);
    }

    @Test
    public void saveIngredient() {
        String id = "1";
        Long recipieId = Long.valueOf(id);
        IngredientsDO ingredientsDO = new IngredientsDO();
        IngredientsDO savedDO = new IngredientsDO();
        ingredientsDO.setRecipieId(recipieId);
        ingredientsDO.setAmount(2L);
        ingredientsDO.setDescription("salt");

        when(recipieService.saveIngredient(ingredientsDO, recipieId)).thenReturn(savedDO);
        ArgumentCaptor<IngredientsDO> argumentCaptor = ArgumentCaptor.forClass(IngredientsDO.class);

        String view = indexController.saveIngredient(ingredientsDO, id);
        assertEquals("redirect:/recipie/ingredient/" + savedDO.getRecipieId(), view);
        verify(recipieService, times(1)).saveIngredient(ingredientsDO, recipieId);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipie-app/index"));
    }
}