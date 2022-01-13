package com.example.cookbook.model;

import org.springframework.hateoas.RepresentationModel;

public class GetIngredientResponse extends RepresentationModel {
    Long id;
    String name;
    GetRecipesWithoutLinkResponse recipe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GetRecipesWithoutLinkResponse getRecipe() {
        return recipe;
    }

    public void setRecipe(GetRecipesWithoutLinkResponse recipe) {
        this.recipe = recipe;
    }
}
