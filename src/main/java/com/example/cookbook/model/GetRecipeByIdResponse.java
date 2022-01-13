package com.example.cookbook.model;

import java.util.List;

public class GetRecipeByIdResponse {
    String name;
    String link;
    List<AddIngredientResponse> ingredients;

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

    public List<AddIngredientResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<AddIngredientResponse> ingredients) {
        this.ingredients = ingredients;
    }
}
