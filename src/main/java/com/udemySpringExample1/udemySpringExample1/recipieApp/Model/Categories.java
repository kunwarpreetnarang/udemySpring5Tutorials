package com.udemySpringExample1.udemySpringExample1.recipieApp.Model;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@ApiModel(description = "Category entity model is used to save different categories of recipes")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipies> recipies = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Recipies> getRecipies() {
        return recipies;
    }

    public void setRecipies(Set<Recipies> recipies) {
        this.recipies = recipies;
    }
}
