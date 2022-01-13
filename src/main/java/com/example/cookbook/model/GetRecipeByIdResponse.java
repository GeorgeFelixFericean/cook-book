package com.example.cookbook.model;

import java.util.List;

public class GetRecipeByIdResponse {
    String name;
    String link;
    List<AddUpdateIngredientResponse> ingredients;

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

    public List<AddUpdateIngredientResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<AddUpdateIngredientResponse> ingredients) {
        this.ingredients = ingredients;
    }
}
