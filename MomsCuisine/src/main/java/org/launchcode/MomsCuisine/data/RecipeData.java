package org.launchcode.MomsCuisine.data;

import org.launchcode.MomsCuisine.models.Recipe;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RecipeData {

  private static final Map<Integer, Recipe> recipes = new HashMap<>();

    //get all recipe
    public static Collection<Recipe> getAll() {
        return recipes.values();
    }

    //get a single recipe
    public static Recipe getById(int id) {
        return recipes.get(id);
    }

    //add a recipe
    public static void add(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
    }

    //remove a recipe
    public static void remove(int id) {
        recipes.remove(id);
    }

}
