package com.example.cookbook.model;

import org.springframework.hateoas.RepresentationModel;

public class GetRecipesWithLinkResponse extends RepresentationModel {
    Long id;
    String name;


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

}
