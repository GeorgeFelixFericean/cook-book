package com.example.cookbook.service;

import com.example.cookbook.mapping.RecipeMapper;
import com.example.cookbook.model.AddRecipeRequest;
import com.example.cookbook.model.AddRecipeResponse;
import com.example.cookbook.model.GetRecipeByIdResponse;
import com.example.cookbook.model.GetRecipesResponse;
import com.example.cookbook.persistence.entities.RecipeEntity;
import com.example.cookbook.persistence.repository.RecipeRepository;
import com.example.cookbook.rest.CookBookController;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class RecipeService {

    RecipeMapper recipeMapper = Mappers.getMapper(RecipeMapper.class);
    private final RecipeRepository recipeRepository;


    //CONSTRUCTOR
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //ADD RECIPE
    public AddRecipeResponse addRecipe(AddRecipeRequest request) {
        return recipeMapper.entityToResponse(recipeRepository.save(recipeMapper.requestToEntity(request)));
    }

    //GET RECIPES
    public List<GetRecipesResponse> getRecipes(String name) {
        List<GetRecipesResponse> responseList = recipeMapper.entitiesToResponses(findByCriteria(name));

        responseList.forEach(getRecipesResponse -> getRecipesResponse.add(linkTo(methodOn(CookBookController.class)
                .getRecipeById(getRecipesResponse.getId()))
                .withRel("Recipe")));

        return responseList.stream()
                .distinct()
                .collect(Collectors.toList());

    }

    //GET RECIPE BY ID
    public GetRecipeByIdResponse getRecipeById(Long id) {
        return recipeMapper.entityToGetResponse(recipeRepository.getById(id));
    }

    //HELPER METHODS
    private List<RecipeEntity> findByCriteria(String name) {
        return recipeRepository.findAll((Specification<RecipeEntity>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isBlank()) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + name + "%")));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
