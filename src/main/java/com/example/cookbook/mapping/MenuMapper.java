package com.example.cookbook.mapping;

import com.example.cookbook.model.AddMenuRequest;
import com.example.cookbook.model.AddMenuResponse;
import com.example.cookbook.persistence.entities.MenuEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MenuMapper {
    AddMenuResponse entityToResponse(MenuEntity entity);

    MenuEntity requestToEntity(AddMenuRequest request);
}
