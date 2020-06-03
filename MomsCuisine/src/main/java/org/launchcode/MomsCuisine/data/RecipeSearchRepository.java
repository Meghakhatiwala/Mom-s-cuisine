package org.launchcode.MomsCuisine.data;

import org.launchcode.MomsCuisine.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeSearchRepository extends JpaRepository<Recipe,Integer> {
    @Query(value="select r.* from recipe r where r.name like '%:searchText%' or r.ingredients like '%:searchText%' or r.preparation_method like '%:searchText%'",
            nativeQuery = true)
    List<Object> getRecipeDetails(@Param("searchText") String searchText);
}