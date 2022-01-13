package com.example.cookbook.service;

import com.example.cookbook.mapping.IngredientMapper;
import com.example.cookbook.model.AddIngredientRequest;
import com.example.cookbook.model.AddIngredientResponse;
import com.example.cookbook.model.GetIngredientResponse;
import com.example.cookbook.persistence.entities.IngredientEntity;
import com.example.cookbook.persistence.entities.RecipeEntity;
import com.example.cookbook.persistence.repository.IngredientRepository;
import com.example.cookbook.persistence.repository.RecipeRepository;
import com.example.cookbook.rest.CookBookController;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class IngredientService {

    IngredientMapper ingredientMapper = Mappers.getMapper(IngredientMapper.class);
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    //CONSTRUCTOR
    public IngredientService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    //ADD INGREDIENT
    public AddIngredientResponse addIngredient(AddIngredientRequest request, Long recipeId) {
        RecipeEntity recipe = recipeRepository.getById(recipeId);

        Optional<IngredientEntity> optional = ingredientRepository.findIngredientEntityByNameAndRecipe(request.getName(), recipe);
        IngredientEntity ingredient;


        if (optional.isPresent()) {
            ingredient = optional.get();
            ingredient.setQuantity(ingredient.getQuantity() + request.getQuantity());
        } else {
            ingredient = ingredientMapper.requestToEntity(request);
            ingredient.setRecipe(recipe);
        }

        return ingredientMapper.entityToResponse(ingredientRepository.save(ingredient));
    }

    //UPDATE INGREDIENT
    public AddIngredientResponse updateIngredient(String name, String quantity, String um, Long id) {

        IngredientEntity ingredient = ingredientRepository.getById(id);

        if (!name.isBlank()) {
            ingredient.setName(name);
        }
        if (!quantity.isBlank()) {
            ingredient.setQuantity(Integer.parseInt(quantity));
        }
        if (!um.isBlank()) {
            ingredient.setUm(um);
        }

        return ingredientMapper.entityToResponse(ingredientRepository.save(ingredient));
    }

    //GET INGREDIENTS
    public List<GetIngredientResponse> getIngredientsByName(String name) {

        List<GetIngredientResponse> responseList =  ingredientMapper.entitiesToResponses(ingredientRepository.findAllByNameLike("%" + name + "%"));


        responseList.forEach(response -> response.add(linkTo(methodOn(CookBookController.class)
                .getRecipeById(response.getRecipe().getId()))
                .withRel("Recipe")));

        return responseList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
