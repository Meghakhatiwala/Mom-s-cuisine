package org.launchcode.MomsCuisine.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private int id;

    @Size(min=3, max = 15)
    @NotBlank
    private String name;

    @Size(min = 5,max = 100)
    @NotBlank
    private String ingredients;

    @Size(max = 500)
    @NotBlank
    private String preparationMethod;

    private CuisineType type;

    public Recipe(String name, String ingredients, String preparationMethod, CuisineType type) {
        this.name = name;
        this.ingredients = ingredients;
        this.preparationMethod = preparationMethod;
        this.type = type;
    }

    public Recipe (){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    public CuisineType getType() {
        return type;
    }

    public void setType(CuisineType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
