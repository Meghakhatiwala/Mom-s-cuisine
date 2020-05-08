package org.launchcode.MomsCuisine.controllers;


import org.launchcode.MomsCuisine.data.RecipeData;
import org.launchcode.MomsCuisine.data.RecipeRepository;
import org.launchcode.MomsCuisine.models.CuisineType;
import org.launchcode.MomsCuisine.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("recipes")
public class RecipeController{

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String displayAllRecipe(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }

    @GetMapping("add")
    public String addRecipeForm(Model model){
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("types", CuisineType.values());
        return "recipes/add";
    }

    @PostMapping("add")
    public String createAddRecipe(@ModelAttribute Recipe newRecipe) {
        recipeRepository.save(newRecipe);
        return "redirect:";
    }

    @GetMapping("delete")
    public String deleteRecipeForm(Model model) {
        model.addAttribute("title", "Delete Recipe");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/delete";
    }

    @PostMapping("delete")
    public String recipeDeleteForm(@RequestParam(required=false) int[] recipeIds){

        if (recipeIds != null) {
            for (int id : recipeIds) {
                recipeRepository.deleteById(id);
            }
        }

           return "redirect:";

    }

}
