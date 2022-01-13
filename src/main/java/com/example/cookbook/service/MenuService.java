package com.example.cookbook.service;

import com.example.cookbook.mapping.MenuMapper;
import com.example.cookbook.model.AddMenuRequest;
import com.example.cookbook.model.AddMenuResponse;
import com.example.cookbook.persistence.repository.MenuRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    MenuMapper menuMapper = Mappers.getMapper(MenuMapper.class);
    private final MenuRepository menuRepository;

    //CONSTRUCTOR
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    //ADD MENU
    public AddMenuResponse addMenu(AddMenuRequest request) {
        return menuMapper.entityToResponse(menuRepository.save(menuMapper.requestToEntity(request)));
    }
}
