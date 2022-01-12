package com.example.cookbook.mapping;

import com.example.cookbook.model.AddIngredientRequestResponse;
import com.example.cookbook.model.GetIngredientResponse;
import com.example.cookbook.persistence.entities.IngredientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IngredientMapper {
    IngredientEntity requestToEntity(AddIngredientRequestResponse request);

    AddIngredientRequestResponse entityToResponse(IngredientEntity entity);

    List<GetIngredientResponse> entitiesToResponses(List<IngredientEntity> entities);
}
