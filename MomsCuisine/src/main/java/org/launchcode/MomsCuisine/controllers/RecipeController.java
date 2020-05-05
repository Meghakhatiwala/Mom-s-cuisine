package org.launchcode.MomsCuisine.controllers;


import org.launchcode.MomsCuisine.data.RecipeData;
import org.launchcode.MomsCuisine.models.Recipe;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("recipes")
public class RecipeController{

    @GetMapping
    public String displayAllRecipe(Model model){
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/index";
    }

    @GetMapping("add")
    public String addRecipeForm(){
         return "recipes/add";
    }

    @PostMapping("add")
    public String createAddRecipe(@RequestParam String recipeName,
                                   @RequestParam String ingredients,
                                   @RequestParam String preparationMethod) {
        RecipeData.add(new Recipe(recipeName, ingredients, preparationMethod ));
        return "redirect:";
    }

    @GetMapping("delete")
    public String deleteRecipeForm(Model model) {
        model.addAttribute("title", "Delete Recipe");
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/delete";
    }

    @PostMapping("delete")
    public String recipeDeleteForm(@RequestParam(required=false) int[] recipeIds){

        if (recipeIds != null) {
            for (int id : recipeIds) {
                RecipeData.remove(id);
            }
        }

           return "redirect:";

    }

}
