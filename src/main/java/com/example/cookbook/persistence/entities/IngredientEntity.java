package com.example.cookbook.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {
    private Long id;
    private String name;
    private Integer quantity;
    private String um;
    private RecipeEntity recipeEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "um", nullable = false)
    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    public RecipeEntity getRecipe() {
        return recipeEntity;
    }

    public void setRecipe(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }
}


