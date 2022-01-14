package com.example.cookbook.service;

import com.example.cookbook.mapping.MenuMapper;
import com.example.cookbook.model.AddMenuRequest;
import com.example.cookbook.model.AddMenuResponse;
import com.example.cookbook.model.AddRecipeResponse;
import com.example.cookbook.persistence.entities.MenuEntity;
import com.example.cookbook.persistence.entities.RecipeEntity;
import com.example.cookbook.persistence.repository.MenuRepository;
import com.example.cookbook.persistence.repository.RecipeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    MenuMapper menuMapper = Mappers.getMapper(MenuMapper.class);
    private final MenuRepository menuRepository;
    private final RecipeRepository recipeRepository;

    //CONSTRUCTOR
    public MenuService(MenuRepository menuRepository, RecipeRepository recipeRepository) {
        this.menuRepository = menuRepository;
        this.recipeRepository = recipeRepository;
    }

    //ADD MENU
    public AddMenuResponse addMenu(AddMenuRequest request) {
        return menuMapper.entityToResponse(menuRepository.save(menuMapper.requestToEntity(request)));
    }

    //ADD RECIPE TO MENU
    public AddRecipeResponse addRecipeToMenu(Long menuId, Long recipeId){

        MenuEntity menu = menuRepository.getById(menuId);
        RecipeEntity recipe = recipeRepository.getById(recipeId);

        menu.getRecipes().add(recipe);
        recipe.getMenus().add(menu);

        menuRepository.save(menu);
        recipeRepository.save(recipe);

        return null;
    }
}
