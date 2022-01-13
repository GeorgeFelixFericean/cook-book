package com.example.cookbook.mapping;

import com.example.cookbook.model.AddRecipeRequest;
import com.example.cookbook.model.AddRecipeResponse;
import com.example.cookbook.model.GetRecipeByIdResponse;
import com.example.cookbook.model.GetRecipesResponse;
import com.example.cookbook.persistence.entities.RecipeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RecipeMapper {
    RecipeEntity requestToEntity(AddRecipeRequest request);

    AddRecipeResponse entityToResponse(RecipeEntity entity);

    List<GetRecipesResponse> entitiesToResponses(List<RecipeEntity> entities);

    GetRecipeByIdResponse entityToGetResponse(RecipeEntity entity);
}
