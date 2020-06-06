package org.launchcode.MomsCuisine.controllers;

import org.launchcode.MomsCuisine.data.RecipeRepository;
import org.launchcode.MomsCuisine.data.RecipeSearchRepository;
import org.launchcode.MomsCuisine.models.CuisineType;
import org.launchcode.MomsCuisine.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("recipes")
public class RecipeController{

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeSearchRepository recipeSearchRepository;


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

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String createAddRecipe(@ModelAttribute Recipe newRecipe, @RequestParam String action) {
        if (action.equals("submit")) {
            recipeRepository.save(newRecipe);
            return "redirect:";
        } else {
            return "redirect:";
        }
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

    @GetMapping("search")
    public String searchRecipeForm(Model model){
       return "recipes/search";
    }

    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String SearchRecipe(Model model, @RequestParam String searchText, @RequestParam String action) {
        if (action.equals("search") && searchText.trim().equals("")) {
            model.addAttribute("recipes", recipeRepository.findAll());
            return "recipes/index";
        } else {
            //searchText = "Rice";
            model.addAttribute("recipes", recipeSearchRepository.getRecipeDetails(searchText));
            return "recipes/index";
        }
    }

}
