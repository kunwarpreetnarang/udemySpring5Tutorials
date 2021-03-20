package com.udemySpringExample1.udemySpringExample1.jokesApp.Controller;

import com.udemySpringExample1.udemySpringExample1.jokesApp.Controllers.JokesController;
import com.udemySpringExample1.udemySpringExample1.jokesApp.Services.JokesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class JokesControllerTest {

    JokesController jokesController;

    @Mock
    Model model;

    @Mock
    JokesService jokesService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        jokesController = new JokesController(jokesService);
    }

    @Test
    public void getJokes() {
       // when(categoryRepository.findByCategoryName("Indian")).thenReturn(categories1);
        String joke="abc";

        when(jokesService.getJokes()).thenReturn(joke);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String view = jokesController.getJokes(model);

        assertEquals("jokes/chuck-norris",view);
        verify(jokesService, times(1)).getJokes();
        verify(model, times(1)).addAttribute(eq("joke"), argumentCaptor.capture());

    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(jokesController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("jokes/chuck-norris"));
    }
}