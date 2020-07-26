package com.udemySpringExample1.udemySpringExample1.jokesApp.Services.impl;

import com.udemySpringExample1.udemySpringExample1.jokesApp.Services.JokesService;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokesServiceImpl implements JokesService{

    private  final ChuckNorrisQuotes chuckNorrisQuotes;

    @Autowired
    public JokesServiceImpl() {
        // used new() instead of parameterized constructor, as it was npt creating bean
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJokes() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
