package com.example.cookbook.model;

import com.example.cookbook.persistence.entities.IngredientEntity;

import java.util.List;

public class GetOneRecipeResponse {
    String name;
    String link;
    List<AddIngredientRequestResponse> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<AddIngredientRequestResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<AddIngredientRequestResponse> ingredients) {
        this.ingredients = ingredients;
    }
}
