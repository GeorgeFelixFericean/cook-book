package com.example.cookbook.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class RecipeEntity {

    private Long id;
    private String name;
    private List<IngredientEntity> ingredients;
    private String link;
    private List<MenuEntity> menus;

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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredientEntities) {
        this.ingredients = ingredientEntities;
    }


    @Basic
    @Column(name = "link", nullable = false)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "menus_recipes",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))
    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }
}

