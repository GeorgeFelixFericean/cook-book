package com.example.cookbook.mapping;

import com.example.cookbook.model.AddRecipeRequestResponse;
import com.example.cookbook.model.GetAllRecipeResponse;
import com.example.cookbook.model.GetOneRecipeResponse;
import com.example.cookbook.persistence.entities.RecipeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RecipeMapper {
    RecipeEntity requestToEntity(AddRecipeRequestResponse request);

    AddRecipeRequestResponse entityToAddResponse(RecipeEntity entity);

    List<GetAllRecipeResponse> entitiesToResponses(List<RecipeEntity> entities);

    GetOneRecipeResponse entityToGetResponse(RecipeEntity entity);
}
