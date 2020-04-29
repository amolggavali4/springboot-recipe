package com.springtest.springbootrecipe.services;

import com.springtest.springbootrecipe.model.Recipe;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();
}
