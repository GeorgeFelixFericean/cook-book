package com.example.cookbook.model;

public class AddIngredientRequestResponse {

    private Long id;
    private String name;
    private Integer quantity;
    private String um;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }
}
