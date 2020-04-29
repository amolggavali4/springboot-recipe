package com.springtest.springbootrecipe.bootstrap;

import com.springtest.springbootrecipe.enums.Difficulty;
import com.springtest.springbootrecipe.model.*;
import com.springtest.springbootrecipe.repositories.CategoryRepository;
import com.springtest.springbootrecipe.repositories.RecipeRepository;
import com.springtest.springbootrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {
    //private final RecipeBook recipeBook;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
                         UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> optionalUnitOfMeasureEach = unitOfMeasureRepository.findByUom("Each");
        if(!optionalUnitOfMeasureEach.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByUom("Tablespoon");
        if(!tablespoonOptional.isPresent()){
            throw new RuntimeException("UOM Tablespoon not found");
        }

        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        if(!teaspoonOptional.isPresent()){
            throw new RuntimeException("UOM Teaspoon not found");
        }

        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByUom("Dash");
        if(!dashOptional.isPresent()){
            throw new RuntimeException("UOM Dash not found");
        }

        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByUom("Pint");
        if(!pintOptional.isPresent()){
            throw new RuntimeException("UOM Pint not found");
        }

        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByUom("Cup");
        if(!cupOptional.isPresent()){
            throw new RuntimeException("UOM Cup not found");
        }

        Optional<Category> americanOptionalCategory = categoryRepository.findByDescription("American");
        if(!americanOptionalCategory.isPresent()){
            throw new RuntimeException("Recipe category - American not found");
        }

        Optional<Category> mexicanOptionalCategory = categoryRepository.findByDescription("Mexican");
        if(!mexicanOptionalCategory.isPresent()){
            throw new RuntimeException("Recipe category - Mexican not found");
        }

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(8);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("Directions");

        Notes notes = new Notes("Notes", guacRecipe);
        //notes.setRecipeNotes("Notes");
        guacRecipe.setNotes(notes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2),optionalUnitOfMeasureEach.get(), guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(5), teaspoonOptional.get(), guacRecipe));
        guacRecipe.getCategories().add(americanOptionalCategory.get());
        guacRecipe.getCategories().add(mexicanOptionalCategory.get());

        recipes.add(guacRecipe);


        return recipes;
    }
}
