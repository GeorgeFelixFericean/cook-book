package com.example.cookbook.mapping;

import com.example.cookbook.model.AddIngredientRequest;
import com.example.cookbook.model.AddUpdateIngredientResponse;
import com.example.cookbook.model.GetIngredientResponse;
import com.example.cookbook.persistence.entities.IngredientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IngredientMapper {
    IngredientEntity requestToEntity(AddIngredientRequest request);

    AddUpdateIngredientResponse entityToResponse(IngredientEntity entity);

    List<GetIngredientResponse> entitiesToResponses(List<IngredientEntity> entities);
}
