package org.launchcode.MomsCuisine.data;

import org.launchcode.MomsCuisine.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeSearchRepository extends JpaRepository<Recipe,Integer> {
    @Query(value="select r.* from recipe r where UPPER(r.name) like %:searchText% or UPPER(r.ingredients) like %:searchText% or UPPER(r.preparation_method) like %:searchText%",
            nativeQuery = true)
    List<Recipe> getRecipeDetails(@Param("searchText") String searchText);
}