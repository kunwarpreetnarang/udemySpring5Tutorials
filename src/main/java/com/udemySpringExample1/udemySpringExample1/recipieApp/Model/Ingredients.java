package com.udemySpringExample1.udemySpringExample1.recipieApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private long amount;

    @ManyToOne
    private Recipies recipies;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;

    public Ingredients(){

    }

    public Ingredients(String description, long amount, UnitOfMeasure unitOfMeasure, Recipies recipies ) {
        this.description = description;
        this.amount = amount;
        this.recipies = recipies;
        this.unitOfMeasure = unitOfMeasure;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Recipies getRecipies() {
        return recipies;
    }

    public void setRecipies(Recipies recipies) {
        this.recipies = recipies;
    }

}
