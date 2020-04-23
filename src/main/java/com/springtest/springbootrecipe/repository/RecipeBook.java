package com.springtest.springbootrecipe.repository;

import com.springtest.springbootrecipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeBook extends CrudRepository<Recipe, Long> {
}
