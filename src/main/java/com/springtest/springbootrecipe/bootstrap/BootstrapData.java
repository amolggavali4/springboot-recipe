package com.springtest.springbootrecipe.bootstrap;

import com.springtest.springbootrecipe.model.Recipe;
import com.springtest.springbootrecipe.repository.RecipeBook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final RecipeBook recipeBook;

    public BootstrapData(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    @Override
    public void run(String... args)  {
        Recipe r1 = new Recipe();
        r1.setName("R1");
        recipeBook.save(r1);

    }
}
