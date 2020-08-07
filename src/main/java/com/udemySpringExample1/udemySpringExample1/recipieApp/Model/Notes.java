package com.udemySpringExample1.udemySpringExample1.recipieApp.Model;

import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    private Recipies recipies;

    private String recipieNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipies getRecipies() {
        return recipies;
    }

    public void setRecipies(Recipies recipies) {
        this.recipies = recipies;
    }

    public String getRecipieNotes() {
        return recipieNotes;
    }

    public void setRecipieNotes(String recipieNotes) {
        this.recipieNotes = recipieNotes;
    }
}
