package com.example.cookbook.rest;

import com.example.cookbook.model.*;
import com.example.cookbook.service.IngredientService;
import com.example.cookbook.service.MenuService;
import com.example.cookbook.service.RecipeService;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CookBookController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final MenuService menuService;


    public CookBookController(RecipeService recipeService, IngredientService ingredientService, MenuService menuService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.menuService = menuService;
    }

    // ADD RECIPE
    @RequestMapping(
            value = "/recipe",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    public ResponseEntity<AddRecipeResponse> addRecipe(
            @ApiParam(value = "JSON payload", required = true)
            @Valid
            @RequestBody AddRecipeRequest request) {
        return ResponseEntity.ok(recipeService.addRecipe(request));
    }

    //ADD INGREDIENT
    @RequestMapping(
            value = "/recipe/{recipeId}/ingredient",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    public ResponseEntity<AddUpdateIngredientResponse> addIngredient(
            @ApiParam(value = "JSON payload", required = true)
            @Valid
            @RequestBody AddIngredientRequest request
            ,
            @ApiParam(value = "The recipe id", required = true)
            @PathVariable("recipeId") Long recipeId) {
        return ResponseEntity.ok(ingredientService.addIngredient(request, recipeId));
    }

    //GET RECIPES
    @RequestMapping(
            value = "/recipe",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    public ResponseEntity<List<GetRecipesWithLinkResponse>> getRecipes(String name) {
        return ResponseEntity.ok(recipeService.getRecipes(name));
    }

    //GET RECIPE BY ID
    @RequestMapping(
            value = "/recipe/{id}",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    public ResponseEntity<GetRecipeByIdResponse> getRecipeById(
            @ApiParam(value = "The recipe id", required = true) @PathVariable("id") Long id) {

        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    //DELETE RECIPE
    @RequestMapping(
            value = "/recipe/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<GetRecipeByIdResponse> deleteRecipe(
            @ApiParam(value = "The recipe id", required = true)
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(recipeService.deleteRecipe(id));
    }


    //TODO - value = "recipe/{recipeId}/ingredient/{ingredientId}"
    //UPDATE INGREDIENT
    @RequestMapping(
            value = "/ingredient/{id}",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.PUT)
    public ResponseEntity<AddUpdateIngredientResponse> updateIngredient(
            @ApiParam(value = "The new name", required = true)
            @Valid
            @RequestParam(value = "name") String name
            ,

            @ApiParam(value = "The new quantity", required = true)
            @Valid
            @RequestParam(value = "quantity") String quantity
            ,
            @ApiParam(value = "The new um", required = true)
            @Valid
            @RequestParam(value = "um") String um
            ,
            @ApiParam(value = "The ingredient id", required = true)
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(ingredientService.updateIngredient(name, quantity, um, id));
    }

    //GET INGREDIENTS BY NAME
    @RequestMapping(
            value = "/ingredient",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.GET)
    public ResponseEntity<List<GetIngredientResponse>> getIngredientsByName(String name) {

        return ResponseEntity.ok(ingredientService.getIngredientsByName(name));
    }

    //ADD MENU
    @RequestMapping(
            value = "/menu",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    public ResponseEntity<AddMenuResponse> addMenu(
            @ApiParam(value = "JSON payload", required = true)
            @Valid
            @RequestBody AddMenuRequest request) {
        return ResponseEntity.ok(menuService.addMenu(request));
    }

    //ADD RECIPE TO MENU
    @RequestMapping(
            value = "/menu/{menuId}/recipe/{recipeId}",
            produces = {"application/json;charset=utf-8"},
            method = RequestMethod.POST)
    public ResponseEntity<AddRecipeResponse> addRecipeToMenu(
            @ApiParam(value = "The menu id", required = true)
            @PathVariable("menuId") Long menuId
            ,
            @ApiParam(value = "The recipe id", required = true)
            @PathVariable("recipeId") Long recipeId) {
        return ResponseEntity.ok(menuService.addRecipeToMenu(menuId, recipeId));
    }

}
