package com.example.cookbook.persistence.repository;

import com.example.cookbook.persistence.entities.IngredientEntity;
import com.example.cookbook.persistence.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    Optional<IngredientEntity> findIngredientEntityByNameAndRecipe(String name, RecipeEntity recipe);

    List<IngredientEntity> findAllByNameLike(String name);
}
