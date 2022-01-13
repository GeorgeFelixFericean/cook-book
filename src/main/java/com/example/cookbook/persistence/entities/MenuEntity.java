package com.example.cookbook.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class MenuEntity {
    private Long id;
    private String name;
    private List<RecipeEntity> recipes;

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

//    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "menus")
    public List<RecipeEntity> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeEntity> recipes) {
        this.recipes = recipes;
    }


}
