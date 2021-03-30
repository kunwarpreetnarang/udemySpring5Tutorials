package com.udemySpringExample1.udemySpringExample1.jokesApp.Services;

import com.udemySpringExample1.udemySpringExample1.jokesApp.Services.impl.JokesServiceImpl;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;


public class JokesServiceImplTest {
    JokesServiceImpl jokesService;

    @Mock
    ChuckNorrisQuotes chuckNorrisQuotes;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        jokesService = new JokesServiceImpl(chuckNorrisQuotes);
    }

    @Test
    public void getJokes() {
        String chuckJoke = "ofidjsdof";
        when(chuckNorrisQuotes.getRandomQuote()).thenReturn(chuckJoke);

        String jokes = jokesService.getJokes();
        assertEquals(chuckJoke, jokes);
    }
}